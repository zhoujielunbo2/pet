package com.example.logistics.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author hexiaobo
 * @title: Base64Utils
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:12
 */
public class Base64Utils {
    /**
     * Base64解密
     *
     * @param decodeToken
     * @return
     */
    public static String getDecoder(String decodeToken) {

        byte[] asBytes = Base64.getDecoder().decode(decodeToken);
        return new String(asBytes, StandardCharsets.UTF_8);

    }
}