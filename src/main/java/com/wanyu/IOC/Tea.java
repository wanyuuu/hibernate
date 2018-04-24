package com.wanyu.IOC;

/**
 * Created by wanyu on 2018/3/19.
 * 通过set注入属性
 */
public class Tea implements Teacher {
    private String name;
    private String type;
    private int age;
    public void teach() {
        System.out.println("姓名："+name);
        System.out.println("课程："+type);
        System.out.println("姓名："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
