package com.wanyu.po;

import javax.persistence.*;

/**
 * Created by wanyu on 2018/3/20.
 */
@Entity
@Table(name = "son", schema = "stu", catalog = "")
public class SonEntity {
    private String sname;
    private Integer age;
    private FatherEntity father;

    @Id
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SonEntity sonEntity = (SonEntity) o;

        if (sname != null ? !sname.equals(sonEntity.sname) : sonEntity.sname != null) return false;
        if (age != null ? !age.equals(sonEntity.age) : sonEntity.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sname != null ? sname.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "name", referencedColumnName = "name")
    public FatherEntity getFather() {
        return father;
    }

    public void setFather(FatherEntity father) {
        this.father = father;
    }
}
