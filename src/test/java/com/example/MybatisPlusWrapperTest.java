package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * author: zy
 * date: 2022/3/12 13:09
 * qq:546359148
 */
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test11(){
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName,"小黑").set(User::getEmail,"xiaohei@qq.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+result);
    }

    @Test
    void test10(){
        String username = "";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(false,User::getAge,ageBegin)
                .le(true,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test09(){
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            //isNotBlank判断某个字符串是否不为空字符串，不为null,不为空白符
            queryWrapper.like("user_name",username);
        }
        //ge是小于<
        queryWrapper.ge("age",ageBegin);
        //le是大于>
        queryWrapper.le("age",ageEnd);

        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    @Test
    void test08(){
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("user_name","小黑").set("email","xiaohei@qq.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+result);

    }

    @Test
    void test07(){
        //查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id <=100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    void test06(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","age","email");
        List<Map<String, Object>> maps =
                userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test05(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                    .and(i->i.gt("age",20)
                    .or()
                    .isNull("email"));

        User user = new User();
        user.setName("小刚");
        user.setEmail("xiaogang@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:"+result);
    }

    @Test
    void test01(){

        //查询用户名包含a,年龄在20到30之间，邮箱信息不为空的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name","J")
                .between("age",10,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void test02(){
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        for (User user : list) {
            System.out.println("user:"+user);
        }
    }

    @Test
    void test03(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:"+result);
    }


    @Test
    void test04(){
        //修改用户名和邮箱，条件是年龄大于20，user_name中带有a或者邮箱是null
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("user_name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("xiaoming@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:"+result);
    }
}
