package com.hrdemo.modle;

import javax.jws.soap.SOAPBinding;

/**
 * Created by OTOT on 2019/5/18.
 */
public class User {
   private int id;
   private String name;
   private String sex;
   public User(int id, String neme, String sex){
       this.id=id;
       this.name=neme;
       this.sex=sex;
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
