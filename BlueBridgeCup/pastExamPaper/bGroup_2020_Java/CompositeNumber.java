package pastExamPaper.bGroup_2020_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 20:36
 * @Version: 1.0
 */

import print.Print;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 合数个数
 * */

public class CompositeNumber {
    static int n;
    static boolean[] isPrime = new boolean[2040];
    public static void EyeSieve(int n){ //埃氏筛法
        Arrays.fill(isPrime, true); //一开始假设都是素数
        for(int i = 2; i*i <= n; i++){
            for(int j = 2*i; j <= n; j+=i){
                if(isPrime[i])
                    isPrime[j] = false; //将i的倍数都变为false，即不是质数
            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
    }

    public static void solve() {
        EyeSieve(2020);
    }

    public static void output() {
//        Print.p1D(isPrime,1,100);
        int cnt = 0;
        for(int i = 1; i <= 2020; i++){
            if( !isPrime[i]) cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
