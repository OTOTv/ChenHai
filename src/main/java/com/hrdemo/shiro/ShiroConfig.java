package com.hrdemo.shiro;

import com.hrdemo.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by OTOT on 2019/5/22.
 */
@Configuration
    public class ShiroConfig {
        @Bean
        public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
            shiroFilterFactoryBean.setLoginUrl("/login");
            // 设置无权限时跳转的 url;
            shiroFilterFactoryBean.setSuccessUrl("/index");
            shiroFilterFactoryBean.setUnauthorizedUrl("/405");
            // 设置拦截器
            Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
            filterChainDefinitionMap.put("/images/**", "anon");
            filterChainDefinitionMap.put("/js/**", "anon");
            filterChainDefinitionMap.put("/css/**", "anon");
            //游客，开发权限
            filterChainDefinitionMap.put("/guest/**", "anon");
            //用户，需要角色权限 “user”
            filterChainDefinitionMap.put("/user/**", "anon");
            //管理员，需要角色权限 “admin”
            //开放登陆接口
            filterChainDefinitionMap.put("/login", "anon");
            //其余接口一律拦截
            //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
           filterChainDefinitionMap.put("/**", "authc");
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            // 必须设置 SecurityManager
            shiroFilterFactoryBean.setSecurityManager(securityManager);
            System.out.println("Shiro拦截器工厂类注入成功");
            return shiroFilterFactoryBean;
        }

        /**
         * 注入 securityManager
         */
        @Bean
        public SecurityManager securityManager() {
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            // 设置realm.
            securityManager.setRealm(customRealm());
            return securityManager;
        }
        @Bean
        public HashedCredentialsMatcher hashedCredentialsMatcher(){
            HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
            hashedCredentialsMatcher.setHashAlgorithmName("MD5");
            hashedCredentialsMatcher.setHashIterations(1);
            return hashedCredentialsMatcher;
        }
        /**
         * 自定义身份认证 realm;
         * <p>
         * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
         * 否则会影响 CustomRealm类 中其他类的依赖注入
         */
        @Bean
        public ShiroRealm customRealm() {
            ShiroRealm shiroRealm=new ShiroRealm();
            shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
            return shiroRealm;
        }
        /*
        * 启用shiro注解
        * */
        @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
            AuthorizationAttributeSourceAdvisor sourceAdvisor=new AuthorizationAttributeSourceAdvisor();
            sourceAdvisor.setSecurityManager(securityManager);
            return sourceAdvisor;
        }


    }