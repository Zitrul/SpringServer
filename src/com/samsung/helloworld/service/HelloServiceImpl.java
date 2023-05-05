package com.samsung.helloworld.service;



import com.samsung.helloworld.db.SQLiteJDBC;
import com.samsung.helloworld.domain.Hello;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{


    @Override
    public Hello getHello(String login,String password) {
        
        if(SQLiteJDBC.check_password(login).equals(password)){
            System.out.println("PASS iS CORRECT");
            return new Hello("CORRECT AUTH");
        }

        return new Hello("WRONG AUTH");
    }
    @Override
    public Hello getReg(String login,String password,Double x, Double y, String email, String phone, String tg) {
        String answer = SQLiteJDBC.write(2,login, password, x,y,email,phone,tg);

        return new Hello(answer);
    }
}
