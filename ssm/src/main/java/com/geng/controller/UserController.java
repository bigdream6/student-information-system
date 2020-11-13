package com.geng.controller;


import com.geng.pojo.*;
import com.geng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/name")
    public List<String> getName(){
        System.out.println(userService.selectName());
        return  userService.selectName();
    }

    @RequestMapping(value = "/findUser/{name}/{password}",produces = "application/json;charset=utf-8")
    public Map getUser(@PathVariable String name,@PathVariable String password){
        Map map = new HashMap<>();
        String result = userService.fingUser(name,password);

        if (result == null || result.length() == 0){
            String result1 = userService.findTeacher(name,password);
            if (result1 == null || result1.length() == 0){

                return  null;
            }else {
               map.put("shen","teacher");

                return map;
            }
        }
        map.put("shen","student");
        map.put("id",Integer.valueOf(result).intValue());
        return  map;
    }

    @RequestMapping(value = "/findClass/{classNo}",produces = "application/json;charset=utf-8")
    public List<User> getClass(@PathVariable String classNo){
        if (userService.findClass(classNo) == null || userService.findClass(classNo).size() == 0){
            return null;
        }
        return userService.findClass(classNo);
    }

    @RequestMapping(value = "/getUser/{id}",produces = "application/json;charset=utf-8")
    public User getUser(@PathVariable int id){

        User user = userService.getUser(id);
        if(user == null){
            return null;
        }
        return user;
    }

    @RequestMapping(value = "/classCount",produces = "application/json;charset=utf-8")
    public List<totalOne> classCount(){
        return userService.classCount();
    }

    @RequestMapping(value = "/ageCount",produces = "application/json;charset=utf-8")
    public List<TotalTwo> ageCount(){
        return userService.ageCount();
    }

    @RequestMapping(value = "/getUserByName/{name}",produces = "application/json;charset=utf-8")
    public List<User> getUserByName(@PathVariable String name){

        List<User> users = userService.findUserByName(name);
        if(users == null || users.size() == 0){
            return null;
        }
        return users;
    }

    @RequestMapping(value = "/getKao",produces = "application/json;charset=utf-8")
    public List<kao> getKao(){
        List<kao> kaos = userService.getKao();
        if(kaos == null || kaos.size() == 0){
            return  null;
        }
        return kaos;
    }

    @RequestMapping(value = "/deleteUser/{id}",produces = "application/json;charset=utf-8")
    public boolean deleteUser(@PathVariable int id){
        boolean c = userService.deleteScore(id);
        boolean b = userService.deleteStu(id);

        if(b && c){
            return true;
        }else {
            return false;
        }

    }

    @RequestMapping(value = "/setUser/{id}/{name}/{age}/{sex}/{classNo}/{ji}",produces = "application/json;charset=utf-8")
    public boolean setUser(@PathVariable int id,@PathVariable String name,@PathVariable int age,@PathVariable String sex,@PathVariable String classNo,@PathVariable String ji){

        boolean b = userService.setUser(id, name, age, sex, classNo, ji);

        return b;
    }

    @RequestMapping(value = "/addUser/{name}/{age}/{sex}/{classNo}/{ji}",produces = "application/json;charset=utf-8")

    public boolean addUser(@PathVariable String name,@PathVariable int age,@PathVariable String sex,@PathVariable String classNo,@PathVariable String ji){
        boolean a = userService.addUser(name, age, sex, classNo, ji);
        int id = userService.selectMax();
        System.out.println(id);
        boolean b = userService.insertScore(id);
        if(a && b){
            return  true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/getScore/{id}",produces = "application/json;charset=utf-8")
    public List<Score> getScore(@PathVariable int id){
        List<Score> list = userService.getScore(id);
        if(list == null || list.size() == 0 || list.get(0) == null){
            return  null;
        }
        return list;
    }
}
