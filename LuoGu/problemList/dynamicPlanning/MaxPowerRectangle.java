package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/14 19:42
 * @Version: 1.0
 */

import java.util.Arrays;
        import java.util.Scanner;
/**
 * P1719
 * 最大加权矩形，思路，利用一维的最大子数组和，这道题和蓝桥学院讲的解法一样
 * */
public class MaxPowerRectangle {
    static int n;
    static int[][] mat; //矩阵matrix
    public static int maxSubPartofArray(int a[]){
        int len = a.length;
        int[] dp = new int[len];
        dp[0] = a[0];
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, dp[0]);
        for(int i = 1; i < len; i++){
            if(dp[i-1] >= 0) dp[i] = dp[i-1] + a[i];
            else dp[i] = a[i];

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static void solve() {
        int rowCurrent = 0;
        int[] sumOfCol = new int[n];

        int max = Integer.MIN_VALUE;
        while(rowCurrent < n){
            for(int i = rowCurrent; i < n; i++){
                for(int j = 0; j < n; j++){
                    //求列和
                    sumOfCol[j] += mat[i][j];
                }
                int t = maxSubPartofArray(sumOfCol);
                max = Math.max(max, t);
            }
            Arrays.fill(sumOfCol, 0); //清零
            rowCurrent++; //下一行
        }

        System.out.println(max);
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
