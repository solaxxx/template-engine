package com.rishiqing.schedule;

import com.rishiqing.bean.LogStash.LogStash;
import com.rishiqing.bean.bat.Bat1;
import com.rishiqing.bean.bat.Bat2;
import com.rishiqing.bean.bat.Bat3;
import com.rishiqing.bean.bat.MappingBat;
import pers.solax.generator.Velocity;
import pers.solax.schedule.BaseSchedule;
import pers.solax.util.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by solax on 2017-3-27.
 */
public class LocalSchedule extends BaseSchedule {

    final static String  BASE_PATH = "E:\\elastic\\logstash-5.2.1\\bin\\import\\";

    final static String KANBAN = "kanban";

    protected final static String INDEX_KANBAN =  "local_kanban";

    public LocalSchedule () {
        super();
    }

    protected void schedule () {
        // 看板相关
        LogStash logStash1=  new LogStash();
        logStash1.set("index", INDEX_KANBAN);
        logStash1.set("document_type", "kanban");
        logStash1.set("statement", "SELECT * from kanban");
        logStash1.set("vm",VM_CONF);
        schedule.put(BASE_PATH + "kanban\\kanban\\conf\\kanban.conf", logStash1.toMap());

        LogStash logStash2 =  new LogStash();
        logStash1.set("index", INDEX_KANBAN);
        logStash2.set("document_type", "kanban_user_link");
        logStash2.set("statement", "SELECT * from kanban_user_link");
        logStash2.set("parent", "${kanban_id}");
        logStash2.set("vm", VM_CONF);
        schedule.put(BASE_PATH + "kanban\\kanban\\conf\\kanban_user_link.conf", logStash2.toMap());

        MappingBat mappingBat = new MappingBat();
        mappingBat.setParent("kanban");
        mappingBat.setIndex(INDEX_KANBAN);
        List<String> mappingList = new ArrayList<String>();
        mappingList.add("kanban_user_link");
        mappingBat.setMappingList(mappingList);
        Map map1  = mappingBat.toMap();
        map1.put("vm", VM_MAPPING);
        schedule.put(BASE_PATH + "kanban\\kanban\\mapping\\mapping.bat", map1);

        /********************/

        Bat3 bat3 = new Bat3();
        bat3.setImportName(KANBAN + "." + KANBAN);
        List<String> configList = new ArrayList<String>();
        configList.add("kanban" + FILE_TYPE_CONF);
        configList.add("kanban_user_link" + FILE_TYPE_CONF);
        bat3.setConfigList(configList);
        Map map2  =bat3.toMap();
        map2.put("vm", VM_IMPORT_BAT3);
        schedule.put(BASE_PATH + "kanban\\kanban\\import.bat", map2);

        Bat2 bat2 = new Bat2();
        bat2.setImportName(KANBAN);
        bat2.setIndex(INDEX_KANBAN);
        Map mapKanbanImport  =bat2.toMap();
        mapKanbanImport.put("vm", VM_IMPORT_BAT2);
        schedule.put(BASE_PATH + "kanban\\import.bat", mapKanbanImport);

        /***********总的import*********/
        Bat1 bat1 = new Bat1();
        List<String> list=  new ArrayList<String>();
        list.add(KANBAN);
        bat1.setChildList(list);
        Map mapImport  =bat1.toMap();
        mapImport.put("vm", VM_IMPORT_BAT1);
        schedule.put(BASE_PATH + "import.bat", mapImport);

        FileUtil.copy("D:\\ideaGitWorkSpace3\\template-engine\\src\\main\\resources\\mysql-connector-java-5.1.39.jar", BASE_PATH +"mysql-connector-java-5.1.39.jar");
    }
}
