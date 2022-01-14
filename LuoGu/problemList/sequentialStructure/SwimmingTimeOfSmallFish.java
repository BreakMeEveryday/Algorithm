package problemList.sequentialStructure;

import java.util.Scanner;

public class SwimmingTimeOfSmallFish {
    public static void main(String[] args) {
        int hour1,min1,hour2,min2;
        Scanner sc = new Scanner(System.in);
        hour1 = sc.nextInt();
        min1 = sc.nextInt();
        hour2 = sc.nextInt();
        min2 = sc.nextInt();

        int totalMin = (hour2 - hour1)*60 + min2 - min1;
//        System.out.println(totalMin);
        System.out.println(totalMin/60+" "+totalMin%60);
    }
}
