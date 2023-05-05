package com.samsung.helloworld.service;

import com.samsung.helloworld.domain.Hello;

public interface HelloService {
    Hello getHello(String name,String password);
    Hello getReg(String login,String password,Double x, Double y, String email, String phone, String tg);
}
