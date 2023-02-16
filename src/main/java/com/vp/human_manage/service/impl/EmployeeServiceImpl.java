package com.vp.human_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.vp.human_manage.entity.Employee;
import com.vp.human_manage.mapper.EmployeeMapper;
import com.vp.human_manage.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
