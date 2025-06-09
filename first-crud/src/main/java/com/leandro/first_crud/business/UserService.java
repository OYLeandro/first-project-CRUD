package com.leandro.first_crud.business;

import com.leandro.first_crud.infrastructure.entitys.Users;
import com.leandro.first_crud.infrastructure.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private  UsersRepository repository;

    public void saveUsers(Users user){
        repository.saveAndFlush(user);
    }

    public Users findByEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void deleteFindyByEmail(String email){
        repository.deleteFindByEmail(email);
    }

    public void updateFindById(Integer id, Users user){
        Users userEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id Não encontrado!"));
        Users updatedUser = Users.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(updatedUser);
    }


}
