package allPreviousQuestions;

import java.util.Scanner;

public class SendChoclates {//分巧克力
    /**
    * @Params:
     * N:巧克力块数
     * K:小朋友数量
     * H[i]:第i块巧克力的高
     * W[i]:第i块巧克力的宽
     * ans:最大边长
     * 说明：只能切成正方形，而且每块巧克力大小相同
    * */
    static int N,K,right = 100001,left = 1,ans = 0;               //数量最多不超过100000
    static int[] H = new int[100000],W = new int[100000]; //高宽最多不超过100000
    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i = 0; i < N; i++){
            H[i] = sc.nextInt();
            W[i] = sc.nextInt();
        }
    }
    public static void solve(){
        while(left <= right){
//            int mid = (left+right)/2;
            int mid = left;
            int cnt = 0;

            for(int i = 0; i < N; i++){
                cnt+=(H[i]/mid)*(W[i]/mid); //块数
            }

            if(cnt >= K){
//                left = mid+1; //left越来越大
                ans = mid;
            }
            left++;
//            else{
//                right = mid-1;
//            }
        }
    }
    public static void output(){
        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
