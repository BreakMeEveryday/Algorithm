package algoIsGraceful.chapter4;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 19:28
 * @Version: 1.0
 */

/*
*
7
1 -2 3 5 -2 6 -1
* */
import java.util.Scanner;

public class MaxSumOfSubArray { //子数组的最大和
    static int n;
    static int[] nums;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void solve() {
        System.out.println(maxSumOfSubArray(nums));
    }

    public static void output(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    /**
     * 最大子序和算法
     * */
    public static int maxSumOfSubArray(int[] array){
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];

        int Max = Integer.MIN_VALUE;
        Max = Math.max(Max, dp[0]);

        for(int i = 1; i < len; i++){
            if(dp[i-1] >= 0) dp[i] = array[i] + dp[i-1];
            else dp[i] = array[i];
            Max = Math.max(Max, dp[i]); //一定不要忘了记录最大值
        }
//
//        System.out.println("打印dp数组");output(dp);
        return Max;
    }

    public static void main(String[] args) {
        input();
        solve();
//        output();
    }
}
