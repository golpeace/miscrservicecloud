package com.miscloud;

public class SingleBeanLz {

    private SingleBeanLz (){};

    private static SingleBeanLz singleBeanLz;

    public static SingleBeanLz getSingleBeanLzInstence(){
        if (singleBeanLz == null){
            singleBeanLz = new SingleBeanLz();
        }
        return singleBeanLz;
    }
}
