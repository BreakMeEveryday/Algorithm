package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/13 21:25
 * @Version: 1.0
 */

import java.util.Scanner;

public class MaxSubPartOfArray { //最大字段和
    static int n;
    static int[] nums;
    static int[] dp;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void solve() {
        dp[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, dp[0]);
        for(int i = 1; i < n; i++){
            if(dp[i-1] >= 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
