package problemList.sequentialStructure;

import java.util.Scanner;

/*
* ApplesPrologue
* P5709
* */
public class ApplesPrologue {
    public static void main(String[] args) {
        int m,t,s;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        t = sc.nextInt();
        s = sc.nextInt();
        if(0 == t){
            System.out.println(0); //0秒吃一个
            return;
        }else{
            if(0 == s % t){       //正好吃完，苹果没有残余
                System.out.println(Math.max(m - s/t,0)); //与0做比较是防止s秒内就吃光
            }else{
                System.out.println(Math.max(m - s/t - 1, 0));
            }
        }
    }
}
