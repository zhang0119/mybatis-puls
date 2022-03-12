package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * author: zy
 * date: 2022/3/11 20:13
 * qq:546359148
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @MapKey("id")
    Map<String,Object> selectMapById(Long id);
}
