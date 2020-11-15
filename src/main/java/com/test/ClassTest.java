package com.test;

import com.mapper.IClass;
import com.vo.Class;
import com.vo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassTest {
    //编写一个测试用例
    private SqlSession session=null;
    private IClass dao=null;

    @Before //测试方法之前要执行的方法
    public void init(){
        InputStream ins= null;
        try {
            //获取Mybatis的数据库的链接的配置文件
            ins = Resources.getResourceAsStream("mybatis-config.xml");
            //视同Mybatis的链接工厂SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
            //获取数据库的链接 SqlSession
            session = factory.openSession();
            dao=session.getMapper(IClass.class);//
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        if(session!=null){
            session.commit();
            session.close();
        }
    }


    @Test
    public void testSelectAll(){
        if(session!=null){
            List<Class> emos=dao.selectClassAll();
            for(Class temp:emos){
                System.out.println(temp);
            }
        }
    }


    //连表查询一对多
    @Test
    public void testSelectStudent_Class(){
        if(session!=null){
            List<Class> emos= dao.select_Class_Student();
            for(Class temp:emos){
                System.out.println(temp);
            }
        }
    }


}
