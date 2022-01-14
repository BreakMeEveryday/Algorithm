package problemList.branchStructure;

import java.util.Scanner;

/*
* 数的性质
* P5710
* */
public class PropertiesOfNum {
    public static boolean rule1(int num){//是偶数
        return num%2 == 0;
    }
    public static boolean rule2(int num){//4<num<=12
        return 4<num && num<=12;
    }

    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        boolean a = rule1(num) && rule2(num);
        boolean uIM = rule1(num) || rule2(num);
        boolean bWY = (rule1(num) && !rule2(num)) || (!rule1(num) && rule2(num));
        boolean zM = !(rule1(num) || rule2(num));

        int b,c,d,e;
        b = (a==true)? 1:0;
        c = (uIM==true)? 1:0;
        d = (bWY==true)? 1:0;
        e = (zM==true)? 1:0;
        System.out.printf("%d %d %d %d",b,c,d,e);
    }
}
