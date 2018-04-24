package com.wanyu.po;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wanyu on 2018/3/20.
 */
@Entity
@Table(name = "father", schema = "stu", catalog = "")
public class FatherEntity {
    private String name;
    private Integer age;
    private List<SonEntity> sons;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        FatherEntity that = (FatherEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "father",cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    public List<SonEntity> getSons() {
        return sons;
    }

    public void setSons(List<SonEntity> sons) {
        this.sons = sons;
    }
}
