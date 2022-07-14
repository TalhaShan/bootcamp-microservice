package com.bootcamp2.userservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

}
