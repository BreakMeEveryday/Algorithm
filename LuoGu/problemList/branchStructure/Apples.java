package problemList.branchStructure;

import java.util.Scanner;

/*
* Apples
* */
public class Apples {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        if(num <= 1) System.out.println("Today, I ate "+num+" apple.");
        else System.out.println("Today, I ate "+num+" apples.");
    }
}
