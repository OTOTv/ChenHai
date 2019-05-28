package com.hrdemo.controler;

import com.hrdemo.modle.mdmodle.ViData;
import com.hrdemo.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OTOT on 2019/5/27.
 */
@RestController
public class DataController {
    @Autowired
    MongoTemplate template;

    /**
     * @param viData
     * @return
     * 存储数据
     */
    @PostMapping("/setdata.do")
    public Msg upd(ViData viData){
        template.save(viData);
        if (viData==null){
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * @return
     * 显示一次的数据
     */
    @GetMapping("/alldata.do")
    public ViData shoodata(){
        Criteria criteria=Criteria.where("id").is(2);
        Query query=Query.query(criteria);
        return template.findOne(query,ViData.class);
    }

}
