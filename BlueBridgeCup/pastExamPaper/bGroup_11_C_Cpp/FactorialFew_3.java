package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/1 20:39
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * 第3题，阶乘约数
 * 100!有多少个约数？
 * 1.先筛选100以内的素数
 * */
public class FactorialFew_3 {
//    static int n;
    static long ans = 1;
    static boolean[] isPrimes = new boolean[101]; //1-100哪些是素数
    static int[] p = new int[101];

    public static void eSieve(int n){ //埃氏筛法
        Arrays.fill(isPrimes, true);
        for(int i = 2; i <= n; i++){
            if(isPrimes[i]){
                for(int j = 2*i; j <= n; j+=i){
                    isPrimes[j] = false; //将i的倍数全部去掉
                }
            }
        }
    }

    public static void solve() {
        for(int i = 2; i <= 100; i++){
            /*
            这里的i循环就是在模拟1*2*....*100，但是1被自动省略了，由于不能真的将1*...*100那样
            数值太大，无法存储下，除非BigInteger
             */
            int n = i;
            for(int j = 2; j <= n / j; j++){ //即j*j <= n，可这是为什么呢？
                while(n % j == 0){
                    p[j]++;
                    n /= j;
                }
            }
            if(n > 1)p[n]++;//除到最后，n自己也是一个质数了
        }
    }

    public static void output() {
        for(int i = 2; i <= 100; i++){
            if(p[i] > 0) ans *= (p[i]+1); //这个公式在考场上就很难想到
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
