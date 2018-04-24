package com.wanyu.po;

import javax.persistence.*;

/**
 * Created by wanyu on 2018/3/19.
 */
@Entity
@Table(name = "wife", schema = "stu", catalog = "")
public class WifeEntity {
    private int id;
    private String wname;
    private HusEntity hus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wname")
    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WifeEntity that = (WifeEntity) o;

        if (id != that.id) return false;
        if (wname != null ? !wname.equals(that.wname) : that.wname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wname != null ? wname.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "wife")
    public HusEntity getHus() {
        return hus;
    }

    public void setHus(HusEntity hus) {
        this.hus = hus;
    }
}
