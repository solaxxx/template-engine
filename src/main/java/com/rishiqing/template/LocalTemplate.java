package com.rishiqing.template;

import com.rishiqing.bean.LogStash.LogStash;
import com.rishiqing.bean.bat.Bat1;
import com.rishiqing.bean.bat.Bat2;
import com.rishiqing.bean.bat.Bat3;
import com.rishiqing.bean.bat.MappingBat;
import pers.solax.generator.Velocity;
import pers.solax.template.BaseTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by solax on 2017-3-27.
 */
public class LocalTemplate extends BaseTemplate {

    protected final static String FILE_IMPORT = "import" + FILE_TYPE_BAT;

    protected final static String BASE_PATH = "E:\\elastic\\logstash-5.2.1\\bin\\import\\";


    /**
     * 看板区域
     */
    protected final static String INDEX_KANBAN =  "local_kanban";

    protected final static String KANBAN = "kanban";

    protected final static String KANBAN_USR_LINK = "kanban_user_link";

    protected final static String KANBAN_PATH   = BASE_PATH + KANBAN + "\\";

    protected final static String KANBAN_PATH_KANBAN  = KANBAN_PATH + KANBAN + "\\";

    protected final static String KANBAN_PATH_KANBAN_CONF = KANBAN_PATH_KANBAN + "\\" + "conf" + "\\";

    protected final static String KANBAN_PATH_KANBAN_MAPPING_PATH = KANBAN_PATH_KANBAN + "\\" + "mapping" + "\\";


    public LocalTemplate () {

    }

    private void assembly () {
        this.bat1();
        this.bat2();
        this.bat3();
    }

    /**
     * 生成所有三级目录的bat
     */
    private void bat3 () {
        // kanban , kanban_user_link
        Bat3 bat3 = new Bat3();
        bat3.setImportName(KANBAN + "." + KANBAN);
        List<String> configList = new ArrayList<String>();
        configList.add(KANBAN + FILE_TYPE_CONF);
        configList.add(KANBAN_USR_LINK + FILE_TYPE_CONF);
        bat3.setConfigList(configList);
        Map map  =bat3.toMap();
        this.addFile(KANBAN_PATH_KANBAN + FILE_IMPORT, new Velocity(VM_IMPORT_BAT3).make(map));
    }

    private void bat2 () {
        // kanban import
        Bat2 bat2 = new Bat2();
        bat2.setImportName(KANBAN);
        Map map  =bat2.toMap();
        Velocity velocity =  new Velocity(VM_IMPORT_BAT2);
        String content = velocity.make(map);
        this.addFile(KANBAN_PATH + FILE_IMPORT, content);
    }

    private void bat1 () {
        // total import
        Bat1 bat1 = new Bat1();
        List<String> list=  new ArrayList<String>();
        list.add(KANBAN);
        bat1.setChildList(list);
        Map map  =bat1.toMap();
        Velocity velocity =  new Velocity(VM_IMPORT_BAT1);
        String content = velocity.make(map);
        this.addFile(BASE_PATH + FILE_IMPORT, content);
    }

    private void conf () {
        /**
         *  kanban
         */
        LogStash logStash1=  new LogStash();
        logStash1.set("index", INDEX_KANBAN);
        logStash1.set("document_type", "kanban");
        logStash1.set("statement", "SELECT * from kanban");
        // 添加一个files节点
        this.addFile(KANBAN_PATH_KANBAN_CONF + "kanban.conf", new Velocity(VM_CONF).make(logStash1.getConfig()));
        /**
         *  kanban_user_link
         */
        LogStash logStash2 =  new LogStash();
        logStash1.set("index", INDEX_KANBAN);
        logStash2.set("document_type", "kanban_user_link");
        logStash2.set("statement", "SELECT * from kanban_user_link");
        logStash2.set("parent", "${kanban_id}");
        // 添加一个files节点
        this.addFile(KANBAN_PATH_KANBAN_CONF + "kanban_user_link.conf", new Velocity(VM_CONF).make(logStash2.getConfig()));
    }

    private void mapping () {
        this.kanbanUserLinkMapping();
    }

    private void kanbanUserLinkMapping () {
        /**
         * kanban_user_link
         */
        MappingBat mappingBat = new MappingBat();
        mappingBat.setParent("kanban");
        mappingBat.setIndex(INDEX_KANBAN);
        List <String> mappingList = new ArrayList<String>();
        mappingList.add("kanban_user_link");
        mappingBat.setMappingList(mappingList);
        Map map  =mappingBat.toMap();
    //    this.addFile(KANBAN_PATH_KANBAN_MAPPING + "mapping.bat", new Velocity(VM_IMPORT_BAT1).make(map));
    }
}
