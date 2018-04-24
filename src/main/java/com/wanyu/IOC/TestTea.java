package com.wanyu.IOC;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wanyu on 2018/3/19.
 */
public class TestTea {
    public static void main(String[] args) {
        BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher tea=(Teacher) bf.getBean("tea");//通过xml中id查到
        Teacher tea2=(Teacher) bf.getBean("math");//通过注解查到
        tea.teach();
        tea2.teach();
    }
    @Test
    public void test(){

    }
}
