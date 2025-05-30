package com.example.container;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebContainer {

    public void handleRequest(String request) {

        try {
            Class<?> clazz = Class.forName("com.example.component.TransferController");
            Object instance = clazz.newInstance();
            // reflection to get methods
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                RequestMapping rm = method.getAnnotation(RequestMapping.class);

                if(rm!= null) {
                    String url = rm.url();
                    String methodType = rm.method();

                    if (request.equals(url)) {
                        method.invoke(instance, new Object[]{"1", "2"});
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

}
