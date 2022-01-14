package problemList.search;/**
 * @Author: 李云鹏
 * @Date: 2021/4/11 20:28
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
    static int n;
    static int[] nums;
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = randomIntegerArray(n);
        sc.close();
    }

    public static void solve() {
        Arrays.sort(nums);
        printArrayLine(nums);
        int i = Arrays.binarySearch(nums, 5);
        System.out.println(i);
    }

    public static void output() {

    }

    private static void printArrayLine(int[] arr) {
        // 循环打印数组中的值，没打印10个数就换行
        for (int i = 0; i < arr.length; i++) {
            if (i%10==0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");

        }
        System.out.println();

    }

    public static int[] randomIntegerArray(int n)           //返回由n个随机数组成的整数对象数组
    {
        int[] value = new int[n];
        for (int i=0; i<value.length; i++)
            value[i]=new Integer((int)(Math.random()*50));//产生一个0-49的随机数
        return value;                                     //返回数组引用
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
