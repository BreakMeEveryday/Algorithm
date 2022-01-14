package pastExamPaper;/**
 * @Author: 李云鹏
 * @Date: 2021/6/5 8:23
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortTest {
    static int n;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sc.close();
    }

    public static void solve() {

    }

    public static void output() {

    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,89,4};
        Arrays.sort(arr, Collections.reverseOrder()); //倒序排
        for (int num : arr){
            System.out.println(num);
        }
    }
}
