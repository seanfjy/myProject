package com.fan.myexercise;

import java.util.Scanner;

import lombok.val;

/**
 * 加密 解码  异或运算
 */
public class DecodeTest {

    public static void main(String[] args) {
        val scanner = new Scanner(System.in);
        System.out.println("请输入需要加密的内容：");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^2);
        }
        System.out.println("加密或解密结果如下：");
        System.err.println(new String(chars));
    }
}
