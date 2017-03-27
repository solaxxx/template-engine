package pers.solax.generator;

import pers.solax.collection.FileCollection;
import pers.solax.model.Files;
import pers.solax.schedule.BaseSchedule;
import pers.solax.template.BaseTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by solax on 2017-3-25.
 */
public class Generator {

    FileCollection fileCollection;

    Map<String, Map> schedule;

    public  Generator (BaseTemplate template) {
        this.fileCollection = template.getFileCollection();
    }

    public Generator (BaseSchedule schedule) {
        this.schedule = schedule.getSchedule();
    }

    public void exec () {
        if (this.fileCollection != null) {
            this.execTemplate();
        } else if (schedule != null) {
            this.execSchedule();
        } else {
            System.out.println("no schedule exec from generator");
        }
    }

    /**
     * 通过模版生成
     */
    public void execTemplate () {
        List<Files> filesList = this.fileCollection.getFilesList();
        for (int i = 0; i< filesList.size(); i++) {
            Files files = filesList.get(i);
            Document document = new Document();
            document.make(files.getPath(), files.getContent());
        }
    }

    /**
     * 通过规则生成
     */
    public void execSchedule () {
        fileCollection = new FileCollection();
        for (String key  : schedule.keySet()) {
            Map map = schedule.get(key);
            String content = new Velocity ((String)map.get("vm")).make(map);
            Files files = new Files(key, content);
            fileCollection.add(files);
        }
        this.execTemplate();
    }
}
