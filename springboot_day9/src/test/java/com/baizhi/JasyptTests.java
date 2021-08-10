package com.baizhi;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTests {

    private StringEncryptor stringEncryptor;

    @Autowired
    public JasyptTests(StringEncryptor stringEncryptor) {
        this.stringEncryptor = stringEncryptor;
    }

    @Test
    public void restSecret() {
        ////加密
        //String secret = stringEncryptor.encrypt("123456");
        //System.out.println(secret);

        //解密
        String decrypt = stringEncryptor.decrypt("yJ9pYoT0045KkQ+QRCCRew==");
        System.out.println(decrypt);

    }
}
