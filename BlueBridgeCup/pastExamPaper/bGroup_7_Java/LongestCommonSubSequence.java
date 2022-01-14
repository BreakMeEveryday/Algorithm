package pastExamPaper.bGroup_7_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 15:38
 * @Version: 1.0
 */

import print.Print;

import java.util.Scanner;

public class LongestCommonSubSequence {
    static int n;
    static String A;
    static String B;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLine();
        B = sc.nextLine();
        sc.close();
    }

    public static void solve() {
        int[][] dp = new int[5000][5000];
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int cnt = 0;
        for(int i = 0; i <= A.length(); i++){
            for(int j = 0; j <= B.length(); j++){
                if(dp[i][j] == dp[A.length()][B.length()])
                    cnt++;
            }
        }

        Print.p2D(dp,0,A.length()+1,0,B.length()+1);
        System.out.println(dp[A.length()][B.length()]);
        System.out.println(cnt);
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
