package problemList.branchStructure;

import java.util.Scanner;

/*
* 洛谷团队系统
* P5731
* */
public class SystemOfGroupOfLuoGu {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //5n 与 3n+11
        if(2*n < 11) System.out.println("Local");
        else System.out.println("Luogu");
    }
}
