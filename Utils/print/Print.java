package print;/**
 * Author: 李云鹏
 * Date: 2021/6/4 15:20
 * Version: 1.0
 */

public class Print{ //打印类，方便打印各种矩阵
    //如何使用泛型？
    public static void p1D(int[] arr, int from, int end){ //打印一维矩阵
        for(int i = from; i < end; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void p2D(int[][] arr, int rowFrom, int rowEnd, int colFrom, int colEnd){
        for(int i = rowFrom; i < rowEnd; i++){
            for(int j = colFrom; j < colEnd; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void p1D(boolean[] arr, int from, int end){ //打印一维矩阵
        for(int i = from; i < end; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void p2D(boolean[][] arr, int rowFrom, int rowEnd, int colFrom, int colEnd){
        for(int i = rowFrom; i < rowEnd; i++){
            for(int j = colFrom; j < colEnd; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
            System.out.println("hotFix hello world");
        }
    }
}
