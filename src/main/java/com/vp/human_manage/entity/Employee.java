package com.vp.human_manage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String account;

    private String sex;

    private String phone;

    private int titleId;

    private int status;

    private double basicSalary;

    private String image;

    private String password;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
