package basicTraining;/**
 * @Author: 李云鹏
 * @Date: 2021/5/27 9:41
 * @Version: 1.0
 */

import java.util.Scanner;

public class ExtendOJLD {
    static int n;
    static long x,y;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {

    }

    public static long ext_gcd(long a, long b){
        if(0 == b){
            x = 1;
            y = 0;
            return a;
        }
        long res = ext_gcd(b, a%b);
        long x1 = x;
        x = y;
        y = x1 - a/b*y;
        return res;
    }

    public static void output() {

    }

    public static void main(String[] args) {
//        input();
//        solve();
//        output();
        ext_gcd(7,42);
        System.out.println(x+" "+y);
    }
}
