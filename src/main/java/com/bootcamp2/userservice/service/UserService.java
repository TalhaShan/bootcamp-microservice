package com.bootcamp2.userservice.service;

import com.bootcamp2.userservice.UserRequestDto;
import com.bootcamp2.userservice.VO.Department;
import com.bootcamp2.userservice.VO.ResponseTemplateVO;
import com.bootcamp2.userservice.entity.User;
import com.bootcamp2.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(UserRequestDto userRequestDto) {
        log.info("Save in service user" + userRequestDto.getEmail());
        User user = new User();

        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setDepartmentId(userRequestDto.getDepartmentId());

        userRepository.save(user);
        return user;

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Getting user Uwith depart");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
