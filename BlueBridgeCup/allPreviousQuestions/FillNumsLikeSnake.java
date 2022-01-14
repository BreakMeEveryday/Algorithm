package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/17 16:44
 * @Version: 1.0
 */

import java.util.Scanner;
/**
 * 蛇形填数
 * */
public class FillNumsLikeSnake {
    static int n;
    static int cnt;
    static int[][] num = new int[100][100];

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {
        cnt = 1;
        num[1][1] = cnt++;
        int x = 1,y = 2;
        while(true){
            if(x == 20 && y == 20) break;
            x++;
            while(y>0){
                if(x == 20 && y == 20) break;
                num[x++][y--] = cnt++;
            }
            y++;
            while(x>0){
                if(x == 20 && y == 20) break;
                num[x--][y++] = cnt++;
            }
            if(x == 20 && y == 20) break;
        }
        System.out.println(num[20][20]);

    }

    public static void output() {

    }

    public static void main(String[] args) {
//        input();
        solve();
        output();
    }
}
