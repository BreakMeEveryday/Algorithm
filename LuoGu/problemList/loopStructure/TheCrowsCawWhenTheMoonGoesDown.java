package problemList.loopStructure;

import java.util.Scanner;

public class TheCrowsCawWhenTheMoonGoesDown {
    static double[] arr = new double[50]; //记忆化数组
    public static double f(int n){
        if(arr[n] != 0) return arr[n];//之前已经有值记录
        if(0 == n) return arr[n] = 0; //返回这个值，并记录，妙
        if(1 == n) return arr[n] = 1;
        return arr[n] = f(n-1)+f(n-2);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.printf("%.2f", f(n));
    }
}
