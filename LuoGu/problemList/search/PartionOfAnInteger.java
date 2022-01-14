package problemList.search;

/*
* 整数拆分
* P2404
* 思路：回溯
* */

import java.util.Arrays;
import java.util.Scanner;

public class PartionOfAnInteger {

    static int n;
    static int[] nums = new int[10001];

    public static void search(int s, int t){

        for(int i = nums[t-1]; i <= s; i++){ //为什么是nums[t-1]?
            if(i < n){//当前数要大于等于前一位数，且不超过n
                nums[t] = i;//保存当前的拆分数i
                s -= i;     //s减去i，s剩下的值继续拆分
                if(0 == s) output(t);//拆分结束
                    else search(s, t+1); //继续拆至第t+1个位置上的数
                s += i;//回溯
            }
        }
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(nums, 1);
        sc.close();
    }

    public static void solve(){
        search(n, 1);  //要拆分的数是n，从1开始拆分
    }

    public static void output(int t){
        for(int i = 1; i <= t-1; i++){
            System.out.print(nums[i]+"+");
        }
        System.out.println(nums[t]);
    }


//    public static void partionOfNum(int num){
//
//    }

    public static void main(String[] args) {
        input();
        solve();
//        output();
    }
}
