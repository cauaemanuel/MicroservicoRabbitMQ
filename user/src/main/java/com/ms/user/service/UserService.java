package com.ms.user.service;

import com.ms.user.DTO.UserDTO;
import com.ms.user.model.Usuario;
import com.ms.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Usuario save(UserDTO dto){

        var user = new Usuario();
        BeanUtils.copyProperties(dto, user);
        userRepository.save(user);
        return user;
    }
}
