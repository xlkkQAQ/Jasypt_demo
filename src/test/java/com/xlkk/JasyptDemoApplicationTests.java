package com.xlkk;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptDemoApplicationTests {

    @Test
    void contextLoads() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("xlkk");
        String username =encryptor.encrypt("root");
        String password =encryptor.encrypt("123456");
//        String password = "123465";
        System.out.println("username:"+username);
        System.out.println("password:"+password);

    }

}
