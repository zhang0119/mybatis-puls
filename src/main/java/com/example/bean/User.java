package com.example.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: zy
 * date: 2022/3/11 20:08
 * qq:546359148
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {

    @TableId(value="id")
    private Long id;

    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic  //代表这个属性是逻辑属性，对应数据库中的逻辑字段is_deleted
    private Integer isDeleted;

}
