package problemList.branchStructure;

import java.util.Scanner;

/*
* 闰年判断
* P5711
* */
public class isLeapYear {
    public static boolean LeapYear(int year){
        if(0 == year%400) return true;
        else if(0 == year%4 && 0 != year%100) return true;
        return false;
    }

    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        if(LeapYear(year)) System.out.println(1);
        else System.out.println(0);
    }
}
