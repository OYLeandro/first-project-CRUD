package com.leandro.first_crud.infrastructure.repository;

import com.leandro.first_crud.infrastructure.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@EnableJpaRepositories
public interface UsersRepository extends JpaRepository<Users, Integer> {
   Optional<Users> findByEmail(String email);

   @Transactional
   void deleteFindByEmail(String email);
}
