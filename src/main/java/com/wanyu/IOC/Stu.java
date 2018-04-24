package com.wanyu.IOC;

/**
 * Created by wanyu on 2018/3/19.
 * 通过构造器依赖注入
 */
public class Stu implements Student {
    private String name;
    private String sex;
    private int age;
    public Stu(String name,String sex,int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }
    public void information() {
        System.out.println("姓名:"+name);
        System.out.println("性别:"+sex);
        System.out.println("年龄:"+age);
    }
}
