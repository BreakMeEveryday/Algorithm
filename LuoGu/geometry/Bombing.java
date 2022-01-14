package geometry;

import java.util.Scanner;

/*
* 题名：轰炸
* 题号：P1142
* */
class point{
     int x; //不写的话，默认
     int y;
}

public class Bombing {
    static int n;
    static point[] p;
    static int max = Integer.MIN_VALUE;

    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = new point[n];
        for(int i = 0; i < n; i++){ //注意，一定要这样初始化！！
            p[i] = new point();
        }
        for(int i = 0; i < n; i++){ //输入n个点
            p[i].x = sc.nextInt();
            p[i].y = sc.nextInt();
        }
    }

    public static void solve(){
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){//任取两个不同点i,j
                int cnt = 2; //直线IJ上的两点i,j，的数量初始就是2
                point vec1 = new point();  //向量
                vec1.x = p[j].x - p[i].x;
                vec1.y = p[j].y - p[i].y;
                for(int h = 0; h < n; h++){ //枚举与i,j不同的点
                    if(h == i || h == j) continue;
                    point vec2 = new point();
                    vec2.x = p[h].x - p[i].x;
                    vec2.y = p[h].y - p[i].y;
                    //向量共线即平行，在同一条直线上
                    if(vec1.x*vec2.y == vec1.y*vec2.x)cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
    }

    public static void output(){
        System.out.println(max);
    }

    public static void main(String[] args) {
      input();
      solve();
      output();
    }
}
