package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * author: zy
 * date: 2022/3/13 2:08
 * qq:546359148
 */
@SpringBootTest
public class MybatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> pages = userMapper.selectPage(page, null);
        System.out.println("page:"+page);

    }
}
