package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/13 20:28
 * @Version: 1.0
 */

/**
 * 采药
 * P1048
 * */
import java.util.Scanner;

//草药类
class Herb{
    int time; //采摘所需时间
    int value;//采摘获得价值
}

public class GatherHerbs {
    static int t;
    static int m;
    static int res = -1;
    static Herb[] herbs;
    static int[][] dp; //dp[i][j] 容量为j，放入前i个物品获得的最大价值，背包容量在本题中是时间
    public static void input() {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        m = sc.nextInt();
        herbs = new Herb[m+1];
        dp = new int[105][1005];
        for(int i = 1; i <= m; i++){
            herbs[i] = new Herb(); //关键
            herbs[i].time = sc.nextInt();
            herbs[i].value = sc.nextInt();
        }
        sc.close();
    }

    public static void solve() {
        for(int i = 1; i <= m; i++){
            for(int j = t; j >= 0; j--){ //背包时间从多到少
                if(j >= herbs[i].time){
                    dp[i][j] = Math.max(dp[i-1][j-herbs[i].time] + herbs[i].value, dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    public static void output() {
        System.out.println(dp[m][t]);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
