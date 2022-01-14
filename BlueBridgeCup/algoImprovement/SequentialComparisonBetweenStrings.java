package algoImprovement;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 16:08
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 字符串间的顺序比较
 * */
public class SequentialComparisonBetweenStrings {
    static char[] s1;
    static char[] s2;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        s1 = sc.nextLine().toCharArray();
        s2 = sc.nextLine().toCharArray();
        sc.close();
    }

    public static int solve() {

        int len = Math.min(s1.length, s2.length);
        for(int i = 0; i < len; i++){
            if(s1[i] < s2[i]){
                return 1;
            }else if(s1[i] > s2[i]){
                return -1;
            }
        }

        //否则就是在长度相等的len范围内一致，要是s1.length > s2.length return 1 else return -1
        if(s1.length > s2.length) return 1;
        else if(s1.length < s2.length) return -1;
        else return 0;
    }

    public static void output() {
        System.out.println(solve());
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
