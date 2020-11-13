package com.geng.service;

import com.geng.dao.UserMapper;
import com.geng.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl  implements  UserService{
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<String> selectName() {
        return userMapper.selectName();
    }

    @Override
    public String fingUser(String username,String password) {
        return userMapper.fingUser(username,password);
    }

    @Override
    public String findTeacher(String name, String password) {
        return userMapper.findTeacher(name,password);
    }

    @Override
    public List<User> findClass(String name) {
        return userMapper.findClass(name);
    }

    @Override
    public User getUser(int id) {
        return  userMapper.getUser(id);
    }

    @Override
    public List<totalOne> classCount() {
        return userMapper.classCount();
    }

    @Override
    public List<TotalTwo> ageCount() {
        return userMapper.ageCount();
    }

    @Override
    public List<User> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<kao> getKao() {
        return  userMapper.getKao();
    }

    @Override
    public boolean deleteStu(int id) {
        return userMapper.deleteStu(id);
    }

    @Override
    public boolean setUser(int id, String name, int age, String sex, String classNo, String ji) {
        return  userMapper.setUser(id, name, age, sex, classNo, ji);
    }

    @Override
    public boolean addUser(String name, int age, String sex, String classNo, String ji) {
        return userMapper.addUser(name, age, sex, classNo, ji);
    }

    @Override
    public List<Score> getScore(int id) {
        return userMapper.getScore(id);
    }

    @Override
    public boolean deleteScore(int id) {
        return userMapper.deleteScore(id);
    }

    @Override
    public boolean insertScore(int id) {
        return userMapper.insertScore(id);
    }

    @Override
    public int selectMax() {
        return userMapper.selectMax();
    }


}
