package com.miscloud;

import java.lang.reflect.Method;

public class Reflect {

    private Pava[] pavas;

    public void get(String name, Pava ... pavas ){
        System.out.println("hhhh");
    }

    private void haha(){

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.miscloud.Reflect");
        Reflect reflect = (Reflect) clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
                for (int j = 0; j < parameterTypes.length; j++) {
                    System.out.println(parameterTypes[j].getName());
                }



        }

    }
}


class Pava{

}