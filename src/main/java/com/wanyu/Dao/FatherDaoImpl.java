package com.wanyu.Dao;

import com.wanyu.po.FatherEntity;
import com.wanyu.po.HusEntity;
import com.wanyu.po.SonEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wanyu on 2018/3/20.
 */
public class FatherDaoImpl {
    private Configuration conf=null;
    private SessionFactory sf=null;
    public FatherDaoImpl(){
        conf=new Configuration().configure("hibernate.cfg.xml");
        sf=conf.buildSessionFactory();
    }
    @Test
    public void queryAll(){
        Session session=sf.openSession();
        FatherEntity father=session.load(FatherEntity.class,"wanyu");
        List<SonEntity> list = father.getSons();
        Iterator<SonEntity> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getSname());
        }
        session.close();
    }
    @Test
    public void add(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();
        trans.begin();
        FatherEntity father=session.load(FatherEntity.class,"wanyu");
        SonEntity son=new SonEntity();
        SonEntity son1=new SonEntity();
        son.setAge(5);
        son.setSname("吴亦凡");
        son.setFather(father);
        father.getSons().add(son);
        son1.setAge(6);
        son1.setSname("华晨宇");
        son1.setFather(father);
        father.getSons().add(son);
        father.getSons().add(son1);
        session.save(father);
        trans.commit();
        session.close();
    }
    @Test
    public void test(){
        FatherEntity father=query();
        System.out.println(father.getName());
        Iterator<SonEntity> it=father.getSons().iterator();
        while(it.hasNext()){
            System.out.println(it.next().getSname());
        }
    }
    public FatherEntity query(){ //懒加载
        Session session=sf.openSession();
        SonEntity sons=session.load(SonEntity.class,"xiao");
        if(!Hibernate.isInitialized(sons.getFather())){
            Hibernate.initialize(sons.getFather());  //把需要查询的实体 放入懒加载中
        }
        if(!Hibernate.isInitialized(sons.getFather().getSons())){
            Hibernate.initialize(sons.getFather().getSons());
        }
        session.close();
        return sons.getFather();
    }
    @Test
    public void query2(){
        Session session=sf.openSession();
        Query query=session.createQuery("from FatherEntity as f");
        query.setCacheable(true);//设置二级缓存 从内存中读取数据
        query.setLockMode("f", LockMode.UPGRADE_NOWAIT);//悲观锁
        List<FatherEntity> father=query.list();
        for(int i=0;i<father.size();i++){
            System.out.println(father.get(i).getName());
        }
        session.close();
    }
}
