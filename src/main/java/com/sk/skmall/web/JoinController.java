package com.sk.skmall.web;

import com.sk.skmall.domain.user.dto.UserDTO;
import com.sk.skmall.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final UserService userServiceImpl;

    @PostMapping("/register/{role-code}")
    public void register(@PathVariable int roleCode, UserDTO user){

        userServiceImpl.joinProcess(user, roleCode);
    }
}