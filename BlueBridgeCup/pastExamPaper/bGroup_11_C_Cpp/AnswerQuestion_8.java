package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/2 15:32
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * 答疑，第8题
 *
 * 输出一个整数，表示同学们在课程群里面发消息的时刻之和最小是多少。
 * 这个输出要求本质是，所有人的等待时间之和最少，那么使用贪心算法即可求得。
 * */
public class AnswerQuestion_8 {
    static int n;
    static int maxn = 100_5;
    static long[] s = new long[maxn]; //第i位同学进入需要的毫秒时间
    static long[] a = new long[maxn]; //第i位同学由老师回答需要的毫秒时间
    static long[] e = new long[maxn]; //第i位同学收拾东西离开办公室需要的时间
    static long[] t = new long[maxn]; //总时间
    static long[] v = new long[maxn];

    static long ans = 0;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            s[i] = sc.nextLong();
            a[i] = sc.nextLong();
            e[i] = sc.nextLong();

            t[i] = s[i] + a[i] + e[i];
            a[i] = s[i] + a[i];//重新处理吗？
        }
        sc.close();
    }

    public static void solve() {
        for(int i = 0; i < n; i++){
            v[i] = t[i];
        }
//        Arrays.sort(v);

        Arrays.sort(t,0,n);
        for(int i = 0; i < n; i++){
            ans += a[i];         //自身的等待时间
            ans += t[i]*(n-1-i); //其他人的等待时间
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
