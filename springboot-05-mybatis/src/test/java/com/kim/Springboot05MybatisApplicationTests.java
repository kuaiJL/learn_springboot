package com.kim;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();

        System.out.println(connection);
        //关闭连接
        connection.close();
    }

    @Test
    void query(){
        String sql = "select * from users where user_name = 'kjl'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
    }

    @Test
    void tt() {
        System.out.println((int)((Math.random()*9+1)*100000));
    }

}
