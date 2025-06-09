package com.leandro.first_crud.infrastructure.dtos;

import com.leandro.first_crud.infrastructure.entitys.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UserDto{

    private String name;
    private String email;
}
