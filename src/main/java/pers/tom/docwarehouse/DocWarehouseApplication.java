package pers.tom.docwarehouse;


import org.apache.commons.codec.binary.Hex;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author tom
 * @description 文档存储库启动类
 * @date 2021/1/28 22:09
 */
@SpringBootApplication
@MapperScan("pers.tom.docwarehouse.mapper")
@EnableAsync
@EnableCaching
public class DocWarehouseApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
//        keyGenerator.init(56);
//        SecretKey secretKey = keyGenerator.generateKey();
//        Cipher cipher = Cipher.getInstance("DES");
//        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//        byte[] result = cipher.doFinal("hello world".getBytes());
//        System.out.println("jdk des encrypt:" + Hex.encodeHexString(result));
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] bytes = cipher.doFinal(result);
//        System.out.println(new String(bytes));
        SpringApplication.run(DocWarehouseApplication.class);
    }
}
