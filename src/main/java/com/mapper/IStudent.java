package com.mapper;

import com.vo.Class;
import com.vo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudent {

    @Insert(" insert into student value (#{id},#{sname},#{math},#{english},#{chinese},#{cid})")
    public void insertStudent(Student emp);

    @Select("select* from student where cid=#{cid}")
    public List<Student> selectStudentById(int cid);

    @Select("select * from student")
    @Results(value = {
            @Result(id =true,property = "id",column = "id"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "math",column = "math"),
            @Result(property = "english",column = "english"),
            @Result(property = "chinese",column = "chinese"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "myclass",column = "cid",many = @Many(select = "com.mapper.IClass.selectClassById"))
    }
    )
    public List<Student> selectStudent_Class();



    @Select("SELECT *FROM student s left outer JOIN class c ON s.cid=c.cid WHERE cname=#{cname} limit  #{pageStart},#{pageSize} ")
    @Results(value = {
            @Result(id =true,property = "id",column = "id"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "math",column = "math"),
            @Result(property = "english",column = "english"),
            @Result(property = "chinese",column = "chinese"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "myclass.cid",column = "cid"),
            @Result(property = "myclass.cname",column = "cname"),
            @Result(property = "myclass.cteacher",column = "cteacher"),
    }
    )
    public List<Student> selectStudent_ClassByCname(@Param("cname") String cname,@Param("pageStart") int pageStart,@Param("pageSize")int pageSize);



    //完成各科成绩的查询（降序），并按照班级级进行成绩汇总

    public List<Student> selectGrade(@Param("cname") String cname,@Param("coures") String coures);

}


