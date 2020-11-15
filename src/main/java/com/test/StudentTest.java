package com.test;

import com.mapper.IClass;
import com.mapper.IStudent;
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
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    //编写一个测试用例
    private SqlSession session=null;
    private IStudent dao=null;

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
            dao=session.getMapper(IStudent.class);//
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
    public void testSelectInsert(){
        if(session!=null){
            Student student1=new Student(20180010,"李六",60,70,80,102);//cid若在class表中不存在，则不能插入
            Student student2=new Student(20180011,"李七",80,74,83,101);
            Student student3=new Student(20180012,"王六",64,90,30,101);
            Student student4=new Student(20180013,"六",65,80,84,103);
            List<Student> list=new ArrayList<Student>();
            list.add(student1);
            list.add(student2);
            list.add(student3);
            list.add(student4);
            for(Student temp:list) {
                dao.insertStudent(temp);
            }
        }
    }

    //连表查询
    @Test
    public void testSelectStudent_Class(){
        if(session!=null){
            List<Student> emos=dao.selectStudent_Class();
            for(Student temp:emos){
                System.out.println(temp);
            }
        }
    }


    //按照班级进行查询，并执行分页操作
    @Test
    public void testSelectStudent_ClassByCname(){
        if(session!=null){
            List<Student> emos=dao.selectStudent_ClassByCname("1班",1,3);
            for(Student temp:emos){
                System.out.println(temp);
            }
        }
    }


    @Test
    public void selectGrade(){
        if(session!=null){
            IStudent studentDao=session.getMapper(IStudent.class);
            List<Student> list = studentDao.selectGrade("1班","math");
            List<Student> list_1 = studentDao.selectGrade("2班","math");

            List<Student> list_2 = studentDao.selectGrade("1班","english");
            List<Student> list_3 = studentDao.selectGrade("2班","english");

            List<Student> list_4 = studentDao.selectGrade("1班","chinese");
            List<Student> list_5 = studentDao.selectGrade("2班","chinese");
            list.addAll(list_1);

            list_2.addAll(list_3);

            list_4.addAll(list_5);
            System.out.println("--------------按照math成绩降序----------");
            for(Student temp:list){
                System.out.println(temp);
            }
            System.out.println("--------------按照english成绩降序----------");
            for(Student temp:list_2){
                System.out.println(temp);
            }

            System.out.println("--------------按照chinese成绩降序----------");
            for(Student temp:list_4){
                System.out.println(temp);
            }
        }
    }



}
