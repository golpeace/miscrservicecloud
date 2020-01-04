package com.miscloud;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class SingleBean {

    private SingleBean(){}

    //饿汉式
    private static final SingleBean singleBeanInstence = new SingleBean();

    public static SingleBean getSingleBeanInstence(){
        return singleBeanInstence;
    }

}
