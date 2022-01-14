package problemList.sequentialStructure;

import java.util.Scanner;

public class LowerCharToUpperChar {
    public static void main(String[] args) {
        char ch;
        Scanner sc = new Scanner(System.in);
        ch =sc.next().charAt(0); //第一个字符
        ch-=32;                  //小写字母的Ascii值更大，中间还隔了[\]^_`六个字符，所以+32
        System.out.println(ch);
//        for(int i = 0; i < 256; i++){
//            System.out.print((char)i);
//            if(i % 10 == 0) System.out.println();
//        }
    }
}
