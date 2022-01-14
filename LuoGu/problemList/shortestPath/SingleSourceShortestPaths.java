package problemList.shortestPath;/**
 * @Author: 李云鹏
 * @Date: 2021/4/17 8:56
 * @Version: 1.0
 */

import java.util.Scanner;
/**
 * 单源最短路径
 * */
class Edge{
    int next;//
    int to;  //
    int dis; //
}

public class SingleSourceShortestPaths {
    static int n;
    static long inf = 0xffffffff;
    static int maxn = 10005;
    static int maxm = 500005;
    static int m,s,sum_edge = 0;
    static int[] dis = new int[maxn];
    static int[] vis = new int[maxn];
    static int[] head = new int[maxm];
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
