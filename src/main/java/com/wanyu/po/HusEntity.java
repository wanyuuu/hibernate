package com.wanyu.po;

import javax.persistence.*;

/**
 * Created by wanyu on 2018/3/19.
 */
@Entity
@Table(name = "hus", schema = "stu", catalog = "")
public class HusEntity {
    private int id;
    private String hname;
    private WifeEntity wife;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hname")
    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HusEntity husEntity = (HusEntity) o;

        if (id != husEntity.id) return false;
        if (hname != null ? !hname.equals(husEntity.hname) : husEntity.hname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hname != null ? hname.hashCode() : 0);
        return result;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public WifeEntity getWife() {
        return wife;
    }

    public void setWife(WifeEntity wife) {
        this.wife = wife;
    }
}
