package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/2 10:42
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 第五题，玩具蛇，答案552
 * */

public class ToySnake_5 {
    static int n = 4; //格子大小
    static int ans = 0;
    static boolean[][] visit = new boolean[n][n];
    static int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    /**
     * 注意，dfs头带visit[x][y] = true
     * 末尾带visit[x][y] = false
     * 是具有回溯效果的dfs
     * 末尾不带visit[x][y] = false是没有回溯效果的
     * */

    public static void dfs(int x, int y, int index){


        visit[x][y] = true;
        if(index == 16){ //16节全部放进格子里了
            ans++;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX < 0 || nextY < 0 || nextX > 3 || nextY > 3) continue; //出界
            if(visit[nextX][nextY]) continue;

            visit[nextX][nextY] = true;
            dfs(nextX,nextY,index+1);
            visit[nextX][nextY] = false; //回溯
        }
        visit[x][y] = false;
    }

    public static void solve() {
        for(int i = 0; i < 4; i++){//将16个点，每个都做一遍起点
            for(int j = 0; j < 4; j++){
//                visit[i][j] = true;
                dfs(i,j,1);
//                visit[i][j] = false;
            }
        }
    }

    public static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
