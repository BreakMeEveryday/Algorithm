package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 18:47
 * @Version: 1.0
 */

import java.util.Scanner;
/**
 * 历届试题 核桃的数量
 *
 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：
 1. 各组的核桃数量必须相同
 2. 各组内必须能平分核桃（当然是不能打碎的）
 3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）
 求三个数的最小公倍数
 * */
public class NumsOfNut { //核桃数量
    static int a;
    static int b;
    static int c;

    public static int LCM(int a, int b, int gcd){
        return a/gcd*b;
    }

    public static int GCD(int m, int n){
        if(0 == n) return m;
        return GCD(n, m%n);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        sc.close();
    }

    public static void solve(){
        /*
        * 1.先求两个数的最小公倍数，再求这个最小公倍数与第三个数的最小公倍数
        * */
        int lcm1 = LCM(a,b,GCD(a,b));
        int lcm2 = LCM(c,lcm1,GCD(lcm1,c));
        System.out.println(lcm2);
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
