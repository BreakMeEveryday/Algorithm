package problemList.dynamicPlanning;

import java.util.Scanner;

/*
5 5 30
3 5 4 2 3
4 5 3 4 3
4 3 5 3 2
2 5 3 3 5
5 3 4 4 1


* */
public class TravelToHongKong {
    static int row, col, totalTime;
    static int[][] map;
    static int[][] dp; //dp[i][j]，走到map[i][j]，在map[i][j]游玩之后，所花费的最大时间
    public static void input(){
        Scanner scan = new Scanner(System.in);
        row = scan.nextInt();
        col = scan.nextInt();
        totalTime = scan.nextInt();
        map = new int[row][col];
        dp = new int[row+1][col+1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map[i][j] = scan.nextInt();
            }
        }
    }

    public static void solve(){
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(i == 0 || j == 0)dp[i][j] = 0; //第一行，第一列初始为0
                dp[i][j] = map[i-1][j-1] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    public static void output(){
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
