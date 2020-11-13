package com.geng.dao;


import com.geng.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    @Select("select name from student")
    List<String> selectName();
    //登录验证 -- 学生
    @Select("select id from student where name = #{username} and stu_password = #{password} ")
    String fingUser(@Param("username") String username, @Param("password") String password);
    //登录验证 -- 老师
    @Select("select teacher_name from teacher where teacher_name = #{name} and teacher_password = #{password}")
    String findTeacher(@Param("name") String name,@Param("password") String password);
    //刷新班级人员详细信息
    @Select("select id,name,age,sex,class_no as classNo ,ji from student where class_no = #{classNo}")
    List<User> findClass(@Param("classNo") String name);
    //根据id查询学生详细信息
    @Select("select id,name,age,sex,class_no as classNo ,ji from student where id = #{id}")
    User getUser(@Param("id") int id);
    //各班级人口比
    @Select("select class_no as classNo, count(name) as count from student group by class_no")
   List<totalOne> classCount();
    //各年龄段人口比
    @Select("select age , count(name) as count from student group by age")
    List<TotalTwo> ageCount();
    //通过姓名搜索信息功能
    @Select("select id,name,age,sex,class_no as classNo ,ji from student where name like  '%${name}%'  ")
    List<User> findUserByName( @Param("name") String name);

    //获取考试信息
    @Select("select kao_name as kaoName,kao_date as kaoDate from kao")
    List<kao> getKao();

    //删除学生信息
    @Delete("delete from student where id = #{id}")
    boolean deleteStu(@Param("id") int id);

    //删除学生考试信息
    @Delete("delete from score where sid = #{id}")
    boolean deleteScore(@Param("id") int id);
    //添加学生考试信息
    @Insert("insert into score (sid) values (#{id})")
    boolean insertScore(@Param("id") int id);
    //查找最大id
    @Select("select Max(id) from student")
    int selectMax();

    @Update("update student set name = #{name},age = #{age},sex = #{sex},class_no = #{classNo},ji = #{ji} where id = #{id}")
    boolean setUser(@Param("id") int id,@Param("name") String name,@Param("age") int age,@Param("sex") String sex,@Param("classNo") String classNo,@Param("ji") String ji);
    //添加信息
    @Insert("insert into student (name, age, sex, class_no, ji) values (#{name},#{age},#{sex},#{classNo},#{ji})")
    boolean addUser(@Param("name") String name,@Param("age") int age,@Param("sex") String sex,@Param("classNo") String classNo,@Param("ji") String ji);

    @Select("select kao_name as kaoName , score from score where sid = #{id}")
    List<Score> getScore(@Param("id")  int id);
}
