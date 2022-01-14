package problemList.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
* 快速排序模版
* P1177
* */
public class QuickSortTest {
//    static int n;
//    static int[] nums;
//    public static void input(){
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = scan.nextInt();
//        }
//        scan.close();
//    }

//    public static void solve(){
//        qSort(nums, 0, n-1);
//    }
//
//    public static void output(){
//
//    }

    public static void qSort(int[] nums, int left, int right){
        int mid = nums[(left - right)/2 + right]; //防止下标溢出的写法
        int i = left, j = right;
        do{
            while(nums[i] < mid) i++; //查找左半部分比中间大的数
            while(nums[j] > mid) j--; //查找右半部分比中间大的数
            if(i <= j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;//交换
                i++;
                j--; //交换完成，脱离原位置，彼此再走一步
            }
        }while(i <= j);
        if(left < j) qSort(nums, left, j); //递归调用
        if(i < right) qSort(nums, i, right);
    }

    public static void main(String[] args) {
        int n = 100;
        int[] nums = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            nums[i] = random.nextInt(1000);//伪随机生成0-999的正整数
        }
        int cnt = 1_000_000; //循环次数
        /*
        * 测试系统自带的快排
        * */
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < cnt; i++){
            int[] tNums = new int[n];
            for(int j = 0; j < n; j++){
                tNums[j] = nums[j];
            }
            Arrays.sort(tNums);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        /*
        * 测试自己写的快排
        * */
        startTime = System.currentTimeMillis();
        for(int i = 0; i < cnt; i++){
            int[] tNums = new int[n];
            for(int j = 0; j < n; j++){
                tNums[j] = nums[j];
            }
            qSort(nums, 0, n-1);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        /*
        * n = 10, 1 0
        * n = 1000,11 4
        * n = 100000,145 124
        * n = 1000000,1055 946
        * 综合说明，手动实现的比系统实现的sort更快一些，但这是为什么呢？
        * */
    }
}
