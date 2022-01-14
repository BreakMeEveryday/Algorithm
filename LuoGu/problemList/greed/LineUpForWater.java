package problemList.greed;/**
 * @Author: 李云鹏
 * @Date: 2021/4/17 16:06
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class LineUpForWater {
    static int n;
    static int[] time;
    static double sum = 0;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        time = new int[n+1];
        for(int i = 1; i <= n; i++){
            time[i] = sc.nextInt()*1001+i; //记住这种特殊的写法，方便排序后得到该数原有的下标，因为总共输入不超过1000个数字，所以用1001，而且即使元素重复，也不会导致不稳定
        }
        sc.close();
    }

    public static void solve() {
        //如何在排序后，保留原有的序号？
        Arrays.sort(time,1, n+1); //左闭右开区间
        for(int i = 1; i <= n; i++){
            System.out.print(time[i] % 1001+" ");
            sum += (time[i]/1001)*(n-i); //i<=1000所以不必考虑i/1001会否有误差
        }
        System.out.println();
    }

    public static void output() {
//        for(int i = 1; i <= n;i++){
//            System.out.print(time[i]+" ");
//        }
        System.out.printf("%.2f",sum/n);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
