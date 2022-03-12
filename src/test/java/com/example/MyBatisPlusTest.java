package com.example;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: zy
 * date: 2022/3/11 20:15
 * qq:546359148
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectList(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println("user:"+user);
        }
    }

    @Test
    void insertUser(){

        User user = new User();
        user.setName("king");
        user.setAge(12);
        int result = userMapper.insert(user);
        System.out.println("result:"+result);

        System.out.println("id:"+user.getId());

    }

    @Test
    void testDeletedById(){
        //通过Id删除用户信息
        /*int result = userMapper.deleteById(1502276115195097090L);
        System.out.println("result==>"+result);*/

        /*Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result==>"+result);*/

        List<Long> list = Arrays.asList(26L, 27L, 28L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:"+result);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@qq.com");
        int result = userMapper.updateById(user);
        System.out.println("result-->"+result);
    }

    @Test
    void testSelect(){

        Map<String, Object> map = userMapper.selectMapById(4L);
        System.out.println(map);
    }
}
