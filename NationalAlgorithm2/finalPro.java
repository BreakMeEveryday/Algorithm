/**
 * @Author: 李云鹏
 * @Date: 2021/6/6 10:59
 * @Version: 1.0
 */

import java.util.Scanner;

public class finalPro {
    static int n;
    static String s;
    static char[] chars;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        chars = new char[n+1];
        chars = s.toCharArray();
        sc.close();
    }

    public static void solve() {
        int p = 0,q = 0;
        int len0;
        int len1;
        int index0 = 0;
        int index1 = 0;
        int[] Len0 = new int[n];
        int[] Len1 = new int[n];

        while(q < n && p < n){
            if(q < n && chars[q] == '0'){
                while(p < n && chars[p] == '0') p++; //一段0的长度是p-q
                len0 = (p-q);
                q = p;
                Len0[index0++] = len0;
            }
            if(q < n && chars[q] == '1'){
                while(p < n && chars[p] == '1') p++; //一段1的长度是p-q
                len1 = (p-q);
                q = p;
                Len1[index1++] = len1;
            }
        }

        int ans0 = 0;
        for(int i = 0; i < index0; i++){
            if(i == index0 - 1){ //特例判断，只有一段连续的0
                ans0 = Math.max(Len0[i], ans0);
            }else{
                ans0 = Math.max(Len0[i]+Len0[i+1], ans0);
            }
        }

        int ans1 = 0;
        for(int i = 0; i < index1; i++){
            if(i == index1 - 1){ //特例判断，只有一段连续的0
                ans1 = Math.max(Len1[i], ans1);
            }else{
                ans1 = Math.max(Len1[i]+Len1[i+1], ans1);
            }
        }

        System.out.println(Math.max(ans0, ans1));
    }

    public static void main(String[] args) {
        input();
        solve();

    }
}
