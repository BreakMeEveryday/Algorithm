package problemList.sort;

import java.util.Scanner;

public class QuickSort {
    static int n;
    static int[] nums;
    public static void input(){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }

    }

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

    public static void output(){
        for(int i = 0; i < n; i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void main(String[] args) {
        input();
        qSort(nums,0,n-1);
        output();
    }
}
