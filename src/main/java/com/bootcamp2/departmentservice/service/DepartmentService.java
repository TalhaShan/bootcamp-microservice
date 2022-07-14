package com.bootcamp2.departmentservice.service;

import com.bootcamp2.departmentservice.entity.Department;
import com.bootcamp2.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
             log.info("Department Service save");
            return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Get Department by id ");

        return departmentRepository.findByDepartmentId(departmentId);
    }
}
