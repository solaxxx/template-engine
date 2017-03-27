package com.rishiqing.bean.bat;

import pers.solax.bean.BaseEntity;

import java.util.List;

/**
 * Created by solax on 2017-3-27.
 */
public class Bat3 extends BaseEntity{
    private String importName;

    private List<String> configList;

    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }
}
