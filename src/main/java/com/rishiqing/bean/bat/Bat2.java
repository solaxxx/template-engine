package com.rishiqing.bean.bat;

import pers.solax.bean.BaseEntity;

/**
 * Created by solax on 2017-3-27.
 */
public class Bat2 extends BaseEntity{

    String importName; // kanban ... corpus

    String userName = "elastic";

    String password = "changeme";

    String host = "http://localhost:9200";

    String index = "es-test";

    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
