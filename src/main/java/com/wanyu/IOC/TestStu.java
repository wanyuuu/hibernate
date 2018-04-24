package com.wanyu.IOC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanyu on 2018/3/19.
 */
public class TestStu {
    public static void main(String[] args) {
        //BeanFactory 工厂模式 核心  application实现了BeanFactory
        BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu=(Student) bf.getBean("stu");
        stu.information();
    }
}
