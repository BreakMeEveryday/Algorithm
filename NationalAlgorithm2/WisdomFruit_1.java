/**
 * @Author: 李云鹏
 * @Date: 2021/6/6 9:18
 * @Version: 1.0
 */

import java.util.Scanner;

public class WisdomFruit_1 { //智慧果
    static int n;
    static int w1 = 1, w2 = 2, w3 = 5;
    static int w1000;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {
        int mod = 100_000;
        for(int i = 4; i <= 1000; i++){
            w1000 = ((((w3*w2*w1)%mod + w3%mod)%mod + w2%mod)%mod + w1%mod)%mod ;
            w1 = w2;
            w2 = w3;
            w3 = w1000;
        }
        System.out.println(w1000);
    }

    public static void output() {

    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
