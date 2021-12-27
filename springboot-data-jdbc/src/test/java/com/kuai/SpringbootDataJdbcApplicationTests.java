package com.kuai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootTest
class SpringbootDataJdbcApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws SQLException {
        ////看一下默认数据源
        //System.out.println(dataSource.getClass());
        ////获得连接
        //Connection connection =   dataSource.getConnection();
        //System.out.println(connection);
        ////关闭连接
        //connection.close();
        String sql = "select * from users";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        //Map<String, Integer> map = new HashMap<>();
        //map.put("apple", 123);
        //map.put("pear", 456);
        //map.put("banana", 789);
        //System.out.println(map.entrySet());
        //System.out.println(map);
        //System.out.println("............................................");
        System.out.println(list);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
            System.out.println("===========================");
        }

    }

    @Test
    public List<Map<String, Object>> userList(){
        String sql = "select * from users";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

}
