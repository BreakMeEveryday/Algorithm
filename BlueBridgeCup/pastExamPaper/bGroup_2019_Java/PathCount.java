package pastExamPaper.bGroup_2019_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 20:54
 * @Version: 1.0
 */

import print.Print;

import java.util.Scanner;

/**
 * 路径计数
 * */
public class PathCount {
    static int[][] map = new int[5][5];
    static boolean[][] visit = new boolean[5][5];
    static int pathCnt = 0;

    static int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public static boolean inBoard(int x, int y){
        return 0 <= x && x <= 4 && 0 <= y && y <= 4;
    }

    public static void dfs(int x, int y,  int dist){ //起点和终点相同，其访问次数要等于2
        if(dist > 12) return;

        if(x == 0 && y == 0){
            if (2 < dist && dist <= 12){ //已经从起点走到终点走了一圈，且总长度不超过12
                pathCnt++;
                return;
            }
        }

        for(int i = 0; i < 4; i++){
            int nextX = x+dir[i][0];
            int nextY = y+dir[i][1];
            if(inBoard(nextX, nextY) && !visit[nextX][nextY]){
                visit[nextX][nextY] = true;
                dfs(nextX,nextY,dist+1);
                visit[nextX][nextY] = false;
            }
        }
    }

    public static void solve() {
        //visit[0][0] == false是一直的
        dfs(0,0,0);
    }

    public static void output() {
        System.out.println(pathCnt);
    }

    public static void main(String[] args) {
        solve();
        output();
    }
}
