package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/5/6.
 */
public class HTest {
    public static void main(String[] args) {
        AgentMoneyLogEntity log = new AgentMoneyLogEntity();
//        log.setId(10001);
        log.setAid(1);
        log.setRelatedId("111");

        try {
            String remark="111µÄ±¸×¢";
            String ret = new String(remark.getBytes("ISO-8859-1"),"GB2312");
            log.setRemark(ret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        log.setCreated(Timestamp.valueOf(dateStr));

       SessionFactory fac=  new AnnotationConfiguration().configure().buildSessionFactory();

//        Configuration configuration = new Configuration();
//        SessionFactory fac = configuration.configure().buildSessionFactory();

        Session session =fac.getCurrentSession();
        session.beginTransaction();
        session.save(log);
        session.getTransaction().commit();
    }
}
