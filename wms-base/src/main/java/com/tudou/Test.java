package com.tudou;

import org.apache.shiro.codec.Base64;

public class Test {
    public static void main(String[] args) throws Exception {
        String ss = "0108632434";
        System.out.println(ss.startsWith("0086"));
        System.out.println(Base64.decodeToString("dHVkb3UxMjM="));
    }
}
