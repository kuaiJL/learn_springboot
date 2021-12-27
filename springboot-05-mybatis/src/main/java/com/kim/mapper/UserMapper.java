package com.kim.mapper;

import com.kim.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //要么在这里加要么在启动类加@MapperScan("com.kim.mapper"),否则报错。
@Repository //可以不加，如果@Repository不加，@Mapper也不加但是加了@MapperScan("com.kim.mapper")，UserMapper注入爆红，但是能运行，
//如果加了@Mapper就可以不加@Repository，类似@Mapper=@Repository+@MapperScan
public interface UserMapper {
    List<User> queryUserList();

    User selectUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    String selectPubKey(String name);
}
