package com.rishiqing.bean.bat;

import pers.solax.bean.BaseEntity;

import java.util.List;

/**
 * Created by solax on 2017-3-27.
 */
public class MappingBat extends BaseEntity{
    String userName = "elastic";

    String password = "changeme";

    String host = "http://localhost:9200";

    String index = "es-test";

    String parent;

    List<String> mappingList;

    public List<String> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<String> mappingList) {
        this.mappingList = mappingList;
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
