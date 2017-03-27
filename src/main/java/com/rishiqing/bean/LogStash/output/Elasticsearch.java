package com.rishiqing.bean.LogStash.output;

/**
 * Created by solax on 2017-3-25.
 */
public class Elasticsearch {
    final static  String HOSTS = "localhost:9200";
    final static  String INDEX = "es-test";
    final static  String DOCUMENT_ID = "%{id}";
    final static  String USER = "user";
    final static  String PASSWORD = "changeme";
    final static  Integer FLUSH_SIZE = 100000;
    final static  Integer IDLE_FLUSH_TIME = 30;

    private String hosts;

    private String index;

    private String document_type;

    private String document_id;

    private String user;

    private String password;

    private Integer flush_size;

    private Integer idle_flush_time;

    private String parent;

    public Elasticsearch () {
        this.setHosts(HOSTS);
        this.setIndex(INDEX);
        this.setDocument_id(DOCUMENT_ID);
        this.setUser(USER);
        this.setPassword(PASSWORD);
        this.setFlush_size(FLUSH_SIZE);
        this.setIdle_flush_time(IDLE_FLUSH_TIME);
    }

    public String getHosts() {
        if (hosts == null) return  HOSTS;
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getIndex() {
        if (index == null) return  INDEX;
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_id() {
        if (document_id == null) return  DOCUMENT_ID;
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getUser() {
        if (user == null) return  USER;
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        if (password == null) return  PASSWORD;
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlush_size() {
        if (flush_size == null) return  FLUSH_SIZE;
        return flush_size;
    }

    public void setFlush_size(Integer flush_size) {
        this.flush_size = flush_size;
    }

    public Integer getIdle_flush_time() {
        if (idle_flush_time == null) return  IDLE_FLUSH_TIME;
        return idle_flush_time;
    }

    public void setIdle_flush_time(Integer idle_flush_time) {
        this.idle_flush_time = idle_flush_time;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
