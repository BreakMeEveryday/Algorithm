package problemList.sequentialStructure;

import java.util.Scanner;

/*
* 数字反转
* P5705
* */
public class ReverseFloatNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();       //String自身没有反转的方法
        s = new StringBuffer(s).reverse().toString(); //借助StringBuffer实现String反转
        System.out.println(s);
    }
}
