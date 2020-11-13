package com.geng.service;

import com.geng.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<String> selectName();

    String fingUser(String username,String password);
    String findTeacher(String name,String password);
    List<User> findClass(String name);
    User getUser(int id);
   List<totalOne> classCount();
    List<TotalTwo> ageCount();
    List<User> findUserByName(String name);
    List<kao> getKao();
    boolean deleteStu( int id);
    boolean setUser( int id, String name, int age, String sex, String classNo, String ji);
    boolean addUser(  String name, int age, String sex, String classNo, String ji);
    List<Score> getScore(int id);
    boolean deleteScore( int id);
    boolean insertScore(int id);
    int selectMax();
}
