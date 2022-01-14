package algoIsGraceful.chapter4;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 19:52
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class MaxSum_of_Sub2DArray { //二维矩阵的子矩阵的最大累加和
    static int n;
    static int[][] matrix = {
            {-90, 48, 78},
            {64, -40, 64},
            {-81, -7, 66}
    };//48-40-7+78+64+66

    public static int maxSum_of_Sub2DArray(int[][] nums){
        int beginRow = 0;
        final int M = nums.length;
        final int N = nums[0].length;

        int[] sumsOfCol = new int[N]; //所有列的和
        int Max = 0;
        while(beginRow < M){
            for(int i = beginRow; i < M; i++){
                //按列累加
                for(int j = 0; j < N; j++){
                    sumsOfCol[j] += nums[i][j];
                }
                //累加完成
                int t = MaxSumOfSubArray.maxSumOfSubArray(sumsOfCol); //统计这个子矩阵的列和，构成的数组，的最大子数组和
                Max = Math.max(Max, t);
            }
            Arrays.fill(sumsOfCol, 0); //清零
            beginRow++;
        }

        return Max;
    }


    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {
        System.out.println(maxSum_of_Sub2DArray(matrix));
    }

    public static void output() {

    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
