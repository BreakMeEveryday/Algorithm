package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 19:51
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;
/**
* 波动序列
*
* */
public class Fluctuations_in_TheSequence {
    static int MAXN = 1100;
    static int MOD = 100_000_007;
    static int[][] F = new int[2][MAXN*MAXN];
    static int e = 0;
    static long n,s,a,b;
    static int cnt = 0;

    public static void DP(long elem){
        F[e][0] = 1;
        for(int i = 1; i < n; i++){ //第i个元素的权值为i
            e = 1-e; //e在0和1之间变化
            for(int j = 0; j <= i*(i+1)/2; j++){
                if(i > j)
                    //由于第i个元素的值本身，已经超过了此时的j，所以第i个元素不能使用
                    F[e][j] = F[1-e][j]; //原有的dp写法是dp[i][j] = dp[i-1][j]，但由于采用了滚动数组，所以F[1-e]代替了dp[i-1][j]
                else
                    //dp[i][j] = dp[i-1][j] + dp[i-1][j-i]
                    //第i个元素不用+使用第i个元素
                    F[e][j] = (F[1-e][j] + F[1-e][j-i]) % MOD;

            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        s = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        sc.close();
    }

    public static void solve() {
        long i,t;
        DP(n*(n-1)/2);
        for(i = 0; i <= n*(n-1)/2; i++){
            t = s - i*a - (n*(n-1)/2 - i) * b; //a与b的个数和为n*(n-1)/2
            if(t % n == 0){//即t/n == x得到的x是个整数
                cnt = (cnt+F[e][(int)i]) % MOD; //此时的e是0是1由dp最后进行的次数决定，F[e][]此时保留了最终状态
            }
        }


    }

    public static void output() {
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
