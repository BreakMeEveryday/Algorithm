package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/13 19:26
 * @Version: 1.0
 */

/**
* 最后一个测试用例超内存
* */
import java.util.Scanner;

public class NumberTriangles {
    static int n;
    static int[][] map;
    static int[][] dp;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static void solve() {
        //从上往下进行dp操作，需要更改原数组
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                map[i][j] += Math.max(map[i-1][j], map[i-1][j-1]); //重点步骤
            }
        }

        int ans = Integer.MIN_VALUE;
        //在最后一行找最大值
        for (int i =1; i <= n; i++) {
            ans = Math.max(ans, map[n][i]);
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
