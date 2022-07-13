package com.xlkk;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
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
        System.out.println("加密后username:"+username);
        System.out.println("加密后password:"+password);

        System.out.println("解密后username"+encryptor.decrypt(username));
        System.out.println("解密后password"+encryptor.decrypt(password));

    }

    @Test
    void Test1(){
        String password = "xlkk";
        PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
        pooledPBEStringEncryptor.setConfig(cryptor(password));

    }

    public SimpleStringPBEConfig cryptor(String password){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        /*---------------------------SimplePBEConfig-------------------------------*/
        config.setPassword(password);
        /**
         * 设置加密算法的值
         * 此算法必须由您的 JCE 提供程序支持，如果此提供程序支持，您还可以为其指定模式和填充，例如ALGORITHM/MODE/PADDING 。
         * 确定结果： getAlgorithm()
         * 参数：
         * algorithm - 要使用的算法的名称
         */
        config.setAlgorithm("PBEWithMD5AndDES");
        /**
         * 设置用于获取加密密钥的散列迭代次数。
         * 确定结果： getKeyObtentionIterations()
         * 参数：keyObtentionIterations – 迭代次数。
         */
        config.setKeyObtentionIterations("1000");
        /**
         * 设置要创建的加密器池的大小。
         * 如果与非池加密器一起使用，此参数将被忽略。
         * 如果未设置，将返回 null。
         * 确定结果： getPoolSize()
         * 参数：poolSize – 如果此配置与池加密器一起使用，则要使用的池大小
         */
        config.setPoolSize("1");
        /**
         * 设置要求加密算法的安全提供者的名称。该提供者应该已经注册。
         * 如果同时设置了providerName和provider属性，则只使用provider ， providerName对 encryptor 对象没有任何意义。
         * 如果未设置，将返回 null。
         * 确定结果： getProviderName()
         * 参数：
         * providerName – 安全提供者的名称。
         */
        config.setProviderName("SunJCE");
        /**
         * 设置盐生成器。
         * 如果未设置，则返回 null。
         * 确定结果： getSaltGenerator()
         * 参数： saltGeneratorClassName – 盐生成器类的名称
         */
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        /**
         * 设置 IV 发生器。
         * 如果未设置，则返回 null。
         * 确定结果： getIvGenerator()
         * 参数：ivGeneratorClassName – IV 生成器类的名称。
         */
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        /*-----------------------------SimpleStringPBEConfig--------------------------------*/
        /**
         * 设置字符串输出的编码形式。可用的编码类型有：
         * base64 （默认）
         * 十六进制
         * 如果未设置，将返回 null。
         * 确定结果： getStringOutputType()
         * 参数：
         * stringOutputType – 字符串输出类型
         */
        config.setStringOutputType("base64");
        return config;
    }

}
