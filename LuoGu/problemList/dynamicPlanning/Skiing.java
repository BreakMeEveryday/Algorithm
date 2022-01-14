package problemList.dynamicPlanning;/**
 * @Author: 李云鹏
 * @Date: 2021/4/13 19:57
 * @Version: 1.0
 */

/**
 * 滑雪
 * P1434
 * */
import java.util.Scanner;

public class Skiing {
    static int n;
    static int m;
    static int[][] dir = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    }; //4个方向
    static int[][] mapHeight = new int[105][105]; //地图高度
    static int[][] memory = new int[105][105]; //记忆化数组
    static int ans = Integer.MIN_VALUE;

    public static boolean inMap(int x, int y){
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }

    public static int dfs(int x, int y){
        if (memory[x][y] != 0) return memory[x][y]; //已经搜过了，memory这个数组记录的是步长数

        memory[x][y] = 1; //这个点本身的长度
        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(inMap(nextX,nextY) && mapHeight[x][y] > mapHeight[nextX][nextY]){
                dfs(nextX, nextY); //这一步走完拿到memory[nextX][nextY]的值
                memory[x][y] = Math.max(memory[x][y], memory[nextX][nextY]+1); //加这个1很重要，这个1代表(x,y)结点本身
            }
        }
        return memory[x][y];
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                mapHeight[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static void solve() {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                ans = Math.max(ans, dfs(i,j));
            }
        }
    }

    public static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
