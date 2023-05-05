package com.samsung.helloworld.controller;

import com.samsung.helloworld.domain.Hello;
import com.samsung.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration/v1")
public class RegistrationController {

    private final HelloService service;

    @Autowired
    public  RegistrationController(HelloService service){
        this.service = service;
    }
    @GetMapping
    public Hello getReg(String login,String password,Double x, Double y, String email, String phone, String tg){
        return service.getReg(login, password, x,y,email,phone,tg);
    }
}