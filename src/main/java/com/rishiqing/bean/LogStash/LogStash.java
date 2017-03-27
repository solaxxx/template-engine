package com.rishiqing.bean.LogStash;

import com.rishiqing.bean.LogStash.input.Jdbc;
import com.rishiqing.bean.LogStash.output.Elasticsearch;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by solax on 2017-3-25.
 */
public class LogStash {

    Jdbc jdbc;

    Elasticsearch elasticsearch;

    Map config = new HashMap();

    public LogStash() {
        jdbc = new Jdbc();
        elasticsearch = new Elasticsearch();
        this.initConfig();
    }

    public void initConfig () {
        try {
            Field[] field = jdbc.getClass().getDeclaredFields();
            for (int i = 0; i < field.length; i ++ ) {
                String modifier = Modifier.toString(field[i].getModifiers()) ;
                if (modifier.indexOf("final") < 0) {
                    field[i].setAccessible(true);
                    config.put(field[i].getName(), field[i].get(this.jdbc));
                }
            }
            Field[] field2 = elasticsearch.getClass().getDeclaredFields();
            for (int i = 0; i < field2.length; i ++ ) {
                String modifier = Modifier.toString(field2[i].getModifiers()) ;
                if (modifier.indexOf("final") < 0) {
                    field2[i].setAccessible(true);
                    config.put(field2[i].getName(), field2[i].get(this.elasticsearch));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set (String key, String value) {
        this.config.put(key, value);
    }

    public void set (String key, int value) {
        this.config.put(key, value);
    }

    public void set (String key, boolean value) {
        this.config.put(key, value);
    }

    public Map getConfig () {
        return config;
    }

    public Map toMap () {
        return config;
    }
}
