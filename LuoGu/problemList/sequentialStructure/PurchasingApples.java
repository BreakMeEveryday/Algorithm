package problemList.sequentialStructure;

import java.util.Scanner;

/*
* 题目：苹果采购
* 题号：P5703
* */
public class PurchasingApples {
    public static void main(String[] args) {
        int numsOfAppleOfEveryone;
        int numsOfIndividuals;
        Scanner sc = new Scanner(System.in);
        numsOfAppleOfEveryone = sc.nextInt();
        numsOfIndividuals = sc.nextInt();
        System.out.println(numsOfAppleOfEveryone*numsOfIndividuals);
        sc.close();
    }
}
