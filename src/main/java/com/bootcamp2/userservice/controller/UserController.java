package com.bootcamp2.userservice.controller;

import com.bootcamp2.userservice.UserRequestDto;
import com.bootcamp2.userservice.VO.ResponseTemplateVO;
import com.bootcamp2.userservice.entity.User;
import com.bootcamp2.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/")
    private User saveUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("Saving user" + userRequestDto.getEmail());
        return userService.saveUser(userRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Getting user with department");
        return userService.getUserWithDepartment(userId);
    }


}
