package com.xlkk.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author xlkk
 * @date 2022/7/13 0013 14:42
 */
public class JasyptUtil {
    public static void main(String[] args) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("xlkk");
        String username =encryptor.decrypt("root");
        String password =encryptor.decrypt("123456");
//        String password = "123465";
        System.out.println("username:"+username);
        System.out.println("password:"+password);


    }
}
