package Month11.Day15;

import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        int n;//总人数
        int m;//间隔出局人数

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int result = 0;  //n=1时的编号情况
        for(int i = 2; i <= n; i++){
            result = (result+m) % i;
            System.out.println("第"+(i-1)+"出局的人是"+result);
        }
        System.out.println("最后出局的人是"+(result+1));
    }
}
