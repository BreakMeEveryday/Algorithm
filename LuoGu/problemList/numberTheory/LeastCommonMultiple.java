package problemList.numberTheory;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 18:35
 * @Version: 1.0
 */

import java.util.Scanner;

public class LeastCommonMultiple { //最小公倍数
    static int n;
    static int m;

    public static int GCD(int m, int n){
        if(0 == n){ //任何数与0的最大公约数都是这个数本身，因为0/任何数 = 0
            return m;
        }
        return GCD(n, m % n);
    }

    public static int LCM(int a, int b, int gcd){   //最小公倍数求解公式 = a*b / gcd(a,b)
        return a/gcd * b;//先写除法，防止乘法溢出
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.close();
    }

    public static void solve() {
        System.out.println(LCM(m,n, GCD(m,n))); //默认m>n
    }

    public static void output() {

    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
