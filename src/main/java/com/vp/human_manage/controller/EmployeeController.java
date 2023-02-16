package com.vp.human_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vp.human_manage.common.R;
import com.vp.human_manage.entity.Employee;
import com.vp.human_manage.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize, String name) {
        log.info("page = {},pageSize = {},name = {}", page, pageSize, name);


        Page pageInfo = new Page(page, pageSize);


        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);

        queryWrapper.orderByDesc(Employee::getCreateTime);


        employeeService.page(pageInfo, queryWrapper);

        return R.success(pageInfo);
    }

    @GetMapping("/list")
    public R<List<Employee>> list() {

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();

        List<Employee> list = employeeService.list(queryWrapper);

        System.out.println(list);

        return R.success(list);
    }

    @PostMapping
    public R<String> save(@RequestBody Employee emp){
        log.info("staff info：{}", emp.toString());

        employeeService.save(emp);

        return R.success("人员添加成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Employee emp) {

        employeeService.updateById(emp);
        return R.success("edit success");
    }

    @DeleteMapping("/{ids}")
    public R<String> delete(@PathVariable Long ids) {
        System.out.println(ids);
        employeeService.removeById(ids);
        return R.success("delete success");
    }
}
