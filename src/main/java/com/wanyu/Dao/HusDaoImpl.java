package com.wanyu.Dao;

import com.wanyu.po.HusEntity;
import com.wanyu.po.WifeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by wanyu on 2018/3/19.
 */
public class HusDaoImpl {
    private Configuration conf=null;
    private SessionFactory sf=null;
    public HusDaoImpl(){
        conf=new Configuration().configure("hibernate.cfg.xml");//配置Configuration对象
        sf=conf.buildSessionFactory();//产生sessionFactory
    }
    @Test
    public void add(){
        Session session=sf.openSession();//创建session对象
        Transaction trans=session.getTransaction();//启动事物
        trans.begin();
        HusEntity hus=new HusEntity();
        hus.setId(3);
        hus.setHname("aaaa");
        WifeEntity wif=new WifeEntity();
        wif.setId(3);
        wif.setWname("bbbb");
        hus.setWife(wif);
        wif.setHus(hus);
        session.save(hus); //A表更新 B表也更新 需添加级联
        trans.commit();
        session.close();
    }
    @Test
    public void del(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();
        trans.begin();
        HusEntity hus=session.load(HusEntity.class,2);//可直接把与之级联的记录删除
//        WifeEntity wif=new WifeEntity();
//        wif.setId(3);
        session.delete(hus);
        trans.commit();
        System.out.println("删除成功");
        session.close();
    }
    @Test
    public void queryAll(){
        Session session=sf.openSession();
//        Transaction trans=session.getTransaction();
        HusEntity hus=session.load(HusEntity.class,1);
        System.out.println(hus.getHname()+hus.getWife().getWname());
        session.close();
    }
    @Test
    public void update(){
        Session session=sf.openSession();
        Transaction trans=session.getTransaction();
        trans.begin();
        HusEntity hus=session.load(HusEntity.class,1);
        hus.getWife().setWname("sabi");
        hus.setHname("dasabi");
        session.update(hus);
        trans.commit();
        session.close();
    }
}
