package problemList.sequentialStructure;

import java.util.Scanner;

public class XiaoYuBuysStationeries {
    public static void main(String[] args) {
        int a,b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        int price = 19;
        int ans = (a*10+b) / price;
        System.out.println(ans);
    }
}
