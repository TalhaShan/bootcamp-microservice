package com.bootcamp2.departmentservice.controller;

import com.bootcamp2.departmentservice.entity.Department;
import com.bootcamp2.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody  Department department){
        log.info("Save Department"+ department.getDepartmentCode());
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Getting department by "+departmentId);
           return     departmentService.findDepartmentById(departmentId);
    }
}
