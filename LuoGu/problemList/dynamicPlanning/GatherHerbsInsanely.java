package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/14 18:56
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 疯狂地采药
 * P1616
 * 1.每种草药可以无限制地采摘，没有原题每种草药只能采摘一次的要求
 * 2.在规定时间内采到最大价值
 *
 * @input:1.时间t， 2.山洞里草药的种类
 *
 * 解析：设f(i,j)表示前i件物品采药j时间能获得的最大价值。
 *
 * */

public class GatherHerbsInsanely {
    static int N = 10005, M = 10000005; //1e4+5, 1e7+5;
    static int n,m;
    static int[] w = new int[N];
    static long[] v = new long[N];
    static long[] f = new long[M];


    public static void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt(); //n种草药

        for(int i = 1; i <= n; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextLong();
        }
        sc.close();
    }

    public static void solve() {
        for(int i = 1; i <= n; i++){//草药数
            for(int j = w[i]; j <= m; j++){ //时间
                f[j] = Math.max(f[j], f[j-w[i]] + v[i]); //使用了滚动数组吗？并没有留存f[i-1]的信息
            }
        }
    }

    public static void output() {
        System.out.println(f[m]);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
