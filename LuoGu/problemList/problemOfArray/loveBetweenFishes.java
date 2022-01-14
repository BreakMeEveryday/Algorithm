package problemList.problemOfArray;

import java.util.Scanner;

/*
* 小鱼比可爱
* P1428
*
* 本质上这道题，是在求数组左边的元素中，小于自己的个数
* */
public class loveBetweenFishes {
    static int n;
    static int[] love;
    static int[] dp; //动态规划，一次遍历，判断左边又多少个值比自己小
    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        love = new int[n];
        for(int i = 0; i < n; i++){
            love[i] = sc.nextInt();
        }
    }
    public static void solve(){

    }
    public static void output(){

    }
    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
