package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 20:24
 * @Version: 1.0
 */

import java.util.Scanner;

public class Fluctuations_in_TheSequence2 {
    static long n,s,a,b;
    static int MAXN = 1010;
    static int MOD = 100_000_007;
    static int e = 0;
    static long cnt = 0;
    static long[][] F = new long[2][MAXN*MAXN];

    public static void DP(long elem){
        F[e][0] = 1; //这句话的含义是没有选择任何的a,a的和为0
        for(int i = 1; i < n; i++){ //代表权值
            e = 1-e; //滚动数组起作用
            for(int j = 0; j <= i*(i+1)/2; j++){
                if(i > j) //不能使用i
                    F[e][j] = F[1-e][j];
                else
                    F[e][j] = (F[1-e][j] + F[1-e][j-i]) % MOD; //不用+用
            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        DP(n*(n-1)/2);
        for(int i = 0; i <= n*(n-i)/2; i++){
            long t = s - i*a - (n*(n-1)/2 - i) * b;
            if(t % n == 0){
                cnt  =  (cnt +  F[e][i]) % MOD;
            }
        }
        System.out.println(cnt);
        sc.close();
    }

    public static void solve() {

    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
