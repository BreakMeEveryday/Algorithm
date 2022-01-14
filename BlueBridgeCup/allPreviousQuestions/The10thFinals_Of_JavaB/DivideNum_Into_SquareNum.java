package allPreviousQuestions.The10thFinals_Of_JavaB;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 8:38
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 平方拆分
 * 拆2019
 * */
public class DivideNum_Into_SquareNum {
    static int n;
    static int cnt = 0;
    public static void input() {
        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
        n = 2500;
        sc.close();
    }

    public static void solve() {
        //开始拆分
        //为什么所有拆分出来的数都是52800？？
        dfs(1, n);
    }

    public static void dfs(int min, int num){
        if(0 == num){
            cnt++;
            return;
        }

        if(num < 0){
            return;
        }

        for(int i = min; i < 50; i++){ //45*45 = 2025 > 2019所以只需要遍历到44即可
            dfs(i+1, num - i*i); //要求拆分出来的数两两不同，****关键****
        }

        //相当于用递归写了很多重循环，就这么简单
    }

    public static void output() {
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
