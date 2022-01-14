package problemList.numberTheory;/**
 * @Author: 李云鹏
 * @Date: 2021/4/11 21:00
 * @Version: 1.0
 */

import java.util.Scanner;

public class GreatestCommonDivisor {
    static int a;
    static int b;

    /**
     * 假设m = k*n + b; // k = m/n, b = m%n;
     * 1.若一个整数i可以同时整除m,n，即m/i和n/i都是整数
     * 2.则 m/i = (k*n)/i + b/i;
     * 3.由于m可以被i整除，n可以被i整除，所以(k*n)也一定可以被i整除，又由于左右整体可被i整除，
     * 所以b也可以被i整除，所以n与b的最大公约数相同
     * */
    public static int gcd(int m, int n){ //辗转相除法，欧几里得辗转相除法的数学原理？
        if(0 == n) return m;
        return gcd(n, m%n);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();
    }

    public static void solve() {

    }

    public static void output() {
        System.out.println(gcd(a,b));
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
