package com.mapper;

import com.vo.Class;
import com.vo.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IClass {
    @Select("select* from class")
    public List<Class> selectClassAll();

    @Select("select* from class where cid=#{cid}")
    public List<Class> selectClassById(int cid);

    @Select("select * from class")
    @Results(value = {
            @Result(id =true,property = "cid",column = "cid"),
            @Result(property = "cname",column = "cname"),
            @Result(property = "cteacher",column = "cteacher"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "studentsList",column = "cid",many = @Many(select = "com.mapper.IStudent.selectStudentById"))
    }
    )
    public List<Class> select_Class_Student();

}
