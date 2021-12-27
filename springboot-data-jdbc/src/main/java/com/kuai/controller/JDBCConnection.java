package com.kuai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCConnection {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from users";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into users(user_id,user_name,user_pubKey) values (6,'汉密尔顿','justok'),(7,'维斯塔潘','niubi')";
        jdbcTemplate.update(sql);
        //查询
        return "addOk";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句
        String sql = "update users set user_name=?,user_pubKey=? where user_id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "汉密尔顿";
        objects[1] = "24736743@sina.com";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateOk";
    }

    //删除用户
    @GetMapping("/delete/{id1}/{id2}")
    public String delUser(@PathVariable("id1") int id1,@PathVariable("id2") int id2){
        //插入语句
        String sql = "delete from users where user_id BETWEEN ? AND ?";
        jdbcTemplate.update(sql,id1,id2);
        //查询
        return "deleteOk";
    }
}
