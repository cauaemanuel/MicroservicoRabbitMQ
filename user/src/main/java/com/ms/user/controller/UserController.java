package com.ms.user.controller;

import com.ms.user.DTO.UserDTO;
import com.ms.user.model.Usuario;
import com.ms.user.repository.UserRepository;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Usuario> saveUser(@RequestBody @Valid UserDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(dto));
    }
}
