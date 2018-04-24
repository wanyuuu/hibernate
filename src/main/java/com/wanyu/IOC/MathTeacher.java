package com.wanyu.IOC;

import org.springframework.stereotype.Component;

/**
 * Created by wanyu on 2018/3/19.
 */
@Component(value = "math")
public class MathTeacher implements Teacher{
    public void teach() {
        System.out.println("一名数学老师");
    }
}
