package com.xunjia.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copyPramaToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String strInt,Integer defaultValue){
        try {
            return Integer.parseInt(strInt, 10);

        }catch (Exception e){
//            e.printStackTrace();
        }

        return defaultValue;
    }
}
