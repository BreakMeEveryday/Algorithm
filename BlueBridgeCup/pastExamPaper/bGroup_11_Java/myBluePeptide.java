package pastExamPaper.bGroup_11_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 14:45
 * @Version: 1.0
 */

import print.Print;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class myBluePeptide {
    static int n;
    static String Astr;
    static String Bstr;
    static int[] A = new int[1024];
    static int[] B = new int[1024];
    static Map<String, Integer> hashMap = new HashMap<>();
    static int[][] dp = new int[1024][1024];

    public static void input() {
        Scanner sc = new Scanner(System.in);
        Astr = sc.nextLine();
        Bstr = sc.nextLine();
        sc.close();
    }

    public static void solve() {
//        int start,end;
        int n = 1;
        int m = 1;
        int cur = 1;

        if(Astr.length() > Bstr.length()){
            String t = Astr;
            Astr = Bstr;
            Bstr = t; //swap
        }

        //A[i]的值是每个肽对应第一次出现的位置，也可以理解为给每个肽打一个标签，本质是区分不同的肽
        for(int start = 0, end; start < Astr.length(); start = end){
            end = start + 1;
            while(end < Astr.length() && Astr.charAt(end) > 'Z') end++; //一直往后找小写字母
            String key = Astr.substring(start, end);
            Integer val = hashMap.get(key);

            if(val == null){ //只有Integer作为一个对象可以被判空，普通的int不能这样写，get确实可能get到null值
                val = cur++;
                hashMap.put(key, val);
            }

            A[n] = val;
            n++;
        }

        for(int start = 0, end; start < Bstr.length(); start = end){
            end = start+1;
            while(end < Bstr.length() && Bstr.charAt(end) > 'Z') end++; //一直往后找小写字母
            String key = Bstr.substring(start, end);
            Integer val = hashMap.get(key);

            if(val != null) //B中出现的肽在A中也出现过
                B[m++] = val;
        }


        //dp求最长公共子序列
        //dp[i][0] = 0; dp[0][j] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A[i] == B[j]) //这个位置出现了同样的肽
                    dp[i][j] = dp[i-1][j-1] + 1;
                else if(A[i] != B[j])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

//        for(int i = 0; i < 2; i++){
//            for(int j = 0; j < 2; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        Print.p2D( dp,0,3,0,3);
        System.out.println(dp[n-1][m-1]); //-1的目的？实际上应该这么写才对
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
