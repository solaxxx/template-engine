package com.rishiqing.bean.bat;

import pers.solax.bean.BaseEntity;

import java.util.List;

/**
 * Created by solax on 2017-3-27.
 */
public class Bat1 extends BaseEntity{

    List<String> childList;

    public List<String> getChildList() {
        return childList;
    }

    public void setChildList(List<String> childList) {
        this.childList = childList;
    }
}
