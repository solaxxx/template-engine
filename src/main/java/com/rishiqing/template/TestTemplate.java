package com.rishiqing.template;

import com.rishiqing.bean.LogStash.LogStash;
import com.rishiqing.bean.bat.Bat1;
import com.rishiqing.bean.bat.Bat2;
import com.rishiqing.bean.bat.Bat3;
import com.rishiqing.bean.bat.MappingBat;
import pers.solax.generator.Velocity;
import pers.solax.model.Files;
import pers.solax.template.BaseTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by solax on 2017-3-25.
 * 本地测试template
 */
public class TestTemplate extends BaseTemplate {
    public TestTemplate() {
        this.assembly();
    }

    private void  assembly () {
        this.logStash ();
        this.bat1();
        this.bat2();
        this.bat3();
        this.mapping();
    }

    private void logStash () {
        // 获得一个logStash配置文件
        LogStash logStash =  new LogStash();
        logStash.set("document_type", "kanban");
        logStash.set("statement", "SELECT * from kanban");
        logStash.set("parent", "11");
        Map logStashMap = logStash.getConfig();
        // 通过velocity组成文件
        Velocity velocity =  new Velocity("conf.vm");
        String content = velocity.make(logStashMap);
        // 添加一个files节点
        this.addFile("E:\\test\\comeon\\kanban.conf", content);
    }
    private void bat1 () {
        Bat1 bat1 = new Bat1();
        List<String> list=  new ArrayList<String>();
        list.add("kanban");
        bat1.setChildList(list);
        Map map  =bat1.toMap();
        Velocity velocity =  new Velocity("import.bat1.vm");
        String content = velocity.make(map);
        this.addFile("E:\\test\\comeon\\import1.bat", content);
    }

    private void bat2 () {
        Bat2 bat2 = new Bat2();
        bat2.setImportName("kanban");
        Map map  =bat2.toMap();
        Velocity velocity =  new Velocity("import.bat2.vm");
        String content = velocity.make(map);
        this.addFile("E:\\test\\comeon\\import2.bat", content);
    }

    private void bat3 () {
        Bat3 bat3 = new Bat3();
        bat3.setImportName("kanban.kanban");
        List<String> configList = new ArrayList<String>();
        configList.add("kanban.conf");
        configList.add("kanban_user_link.conf");
        bat3.setConfigList(configList);
        Map map  =bat3.toMap();
        Velocity velocity =  new Velocity("import.bat3.vm");
        String content = velocity.make(map);
        this.addFile("E:\\test\\comeon\\import.bat", content);
    }

    private void mapping () {
        MappingBat mappingBat = new MappingBat();
        mappingBat.setParent("kanban");
        List <String> mappingList = new ArrayList<String>();
        mappingList.add("kanban_user_link");
        mappingBat.setMappingList(mappingList);
        Map map  =mappingBat.toMap();
        Velocity velocity =  new Velocity("mapping.bat.vm");
        String content = velocity.make(map);
        this.addFile("E:\\test\\comeon\\mapping.bat", content);
    }
}
