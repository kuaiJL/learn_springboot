package com.jr;

import com.jr.pojo.Dog;
import com.jr.pojo.Dog1;
import com.jr.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
    @Autowired
    Dog dog;
    @Autowired
    Dog1 dog1;
    @Autowired
    Person person;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person); //打印person信息
        System.out.println(dog1);
    }

}
