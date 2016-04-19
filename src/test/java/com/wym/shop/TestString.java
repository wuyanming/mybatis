package com.wym.shop;

/**
 * Created by Administrator on 2016/4/18.
 */
public class TestString {
    public static void main (String[] args ){
        String str = "abcdadefbcgf";
        String reg = "(.)(?=.*\\1)";
//        String reg= "(?s)(.)(?=.*\\1)";
//        str = str.replaceAll(reg, "");
        str = new StringBuffer(str).reverse().toString().replaceAll(reg, "");
        str = new StringBuffer(str).reverse().toString();
        System.out.println(str);
    }
}
