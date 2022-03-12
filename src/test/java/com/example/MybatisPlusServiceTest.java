package com.example;

import com.example.bean.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * author: zy
 * date: 2022/3/12 1:30
 * qq:546359148
 */
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testCount(){
        long count = userService.count(null);
        System.out.println("count:"+count);
    }

    @Test
    void testInsertMore(){

        List<User> list = new ArrayList<>();
        for(int i =1 ; i<=5;i++){
            User user = new User();
            user.setName("king"+i);
            user.setAge(20+i);
            user.setEmail("test"+i+"@baomidou.com");
            list.add(user);


        }
        boolean b = userService.saveBatch(list);
        System.out.println(b?"执行成功":"执行失败");
    }
}
