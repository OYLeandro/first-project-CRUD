package com.leandro.first_crud.controller;

import com.leandro.first_crud.business.UserService;
import com.leandro.first_crud.infrastructure.entitys.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody Users user){
        userService.saveUsers(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Users> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFindByEmail(@RequestParam String email){
        userService.deleteFindyByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserFindById(@RequestParam Integer id,
                                                   @RequestBody Users users){
        userService.updateFindById(id, users);
        return ResponseEntity.ok().build();
    }
}
