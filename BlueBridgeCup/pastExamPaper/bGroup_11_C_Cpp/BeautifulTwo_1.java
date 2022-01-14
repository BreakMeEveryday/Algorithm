package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/1 19:18
 * @Version: 1.0
 */

import java.util.Scanner;

/**
* 美丽的2
* */

public class BeautifulTwo_1 {
    static int n = 0;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {
        for(int i = 1; i <= 2020; i++){
            if(ContainsTwo(i)) n++;
        }
    }

    public static void output() {
        System.out.println("总共有"+n+"个数包含2");
    }

    public static boolean ContainsTwo(int num){
        while(num != 0){
            if(num % 10 == 2) return true;
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
