package problemList.sequentialStructure;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        double a,b,c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        double p = (a+b+c)/2;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.printf("%.1f",area);
    }
}
