package com.vp.human_manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vp.human_manage.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
