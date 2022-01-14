package problemList.basicMathProblem;/**
 * @Author: 李云鹏
 * @Date: 2021/4/15 9:03
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 直线之间的交点数，有多少
 * */
public class Nums_Of_CrossPoint_Among_StraightLines {
    static int n;
    static int Max = -1;
    static int ans = 0;
    static boolean[] flag = new boolean[11000]; //每有一个交点数k,f[k] = 0

    public static void g(int n, int k){
        /**
         * r: r条平行线
         * n: n条直线
         *
         * */

        if(0 == n){
            flag[k] = true;
            Max = Math.max(Max, k);
        }else{
            for(int r = n; r >= 1; r--){
                g(n-r, r*(n-r) + k);
            }
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

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
