package com.wanyu.Auto;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanyu on 2018/3/19.
 */
public class Test {
    public static void main(String[] args) {
        BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
        Boss boss=(Boss) bf.getBean("boss");
        System.out.println(boss.toString());
    }
}
