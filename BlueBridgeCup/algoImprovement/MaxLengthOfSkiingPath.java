package algoImprovement;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 10:02
 * @Version: 1.0
 */

import java.util.Scanner;

public class MaxLengthOfSkiingPath {
    static int R; //行数
    static int C; //列数
    static int[][] Height;
    static int[][] Value;
    static int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public static boolean inMap(int x, int y){
        return 1<=x && x<=R && 1<=y && y<=C;
    }

    public static int dfs(int x, int y){
        if(Value[x][y] != 0) return Value[x][y];
        Value[x][y] = 1; //本身算一步

        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(inMap(nextX, nextY) && Height[x][y] > Height[nextX][nextY]){ //inMap先写
                Value[x][y] = Math.max(dfs(nextX, nextY) + 1, Value[x][y]);
            }
        }
        return Value[x][y];
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        Height = new int[R+1][C+1];
        Value = new int[R+1][C+1];
        for (int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                Height[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static void solve() {
        for (int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                dfs(i,j);
            }
        }
    }

    public static void output() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                max = Math.max(max, Value[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
