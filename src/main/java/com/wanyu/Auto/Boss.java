package com.wanyu.Auto;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wanyu on 2018/3/19.
 */
public class Boss {
    @Autowired
    private Car car;
    @Autowired
    private Address address;//自动装配 无需get set

//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "car:"+this.car.getName()+"/n"+"address:"+this.address.getName();
    }
}
