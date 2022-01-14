package pastExamPaper.bGroup_2020_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 20:02
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 国赛：天干地支
 * 公元第100年，庚子年，公元第40年，庚子年，公元0年，庚申年
 * */

public class ChineseEra {
    static int year;
    static int a = 6;
    static int b = 8;
    static String[] TG = {"jia", "yi", "bing", "ding", "wu", "ji","geng", "xin", "ren", "gui"};
    static String[] DZ = {"zi", "chou", "yin", "mao", "chen", "si", "wu", "wei","shen", "you","xu", "hai"};

    public static void input() {
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        sc.close();
    }

    public static void solve() {
//        int value = year % 60;
//        System.out.println(TG[value % 10] + DZ[value % 12]);
        System.out.println(TG[(a+year) % 10] + DZ[(b+year)%12]);
    }


    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
//        System.out.println(2020%60);
    }
}
