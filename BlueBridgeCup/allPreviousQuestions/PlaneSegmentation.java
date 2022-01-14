package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/12 16:46
 * @Version: 1.0
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 平面切分，题意理解
 * 3
 * 1 1
 * 2 2
 * 3 3
 *
 * 输出为6
 *
 * 公式F = N + M + 1
 *
 *
 * */
class point{
    double x;
    double y;
}

public class PlaneSegmentation {
    static int n;
    static double[][] para = new double[1010][2]; //存储参数Ai,Bi
    static long ans = 0;
    static boolean[] isEqualLine = new boolean[1010];
    static point crossPoint = new point(); //点类
    static Scanner sc = new Scanner(System.in);

    public static void input() {
        n = sc.nextInt();
    }

    public static void solve() {
        for(int i = 0; i < n; i++){
            para[i][0] = sc.nextDouble();
            para[i][1] = sc.nextDouble();
            Set<point> points = new HashSet<>(); //内部元素有序
            for(int j = 0; j < i; j++){
                if(isEqualLine[j])continue;//重边
                if(para[i][0] == para[j][0]){ //两条直线斜率相等，判断平行或重合
                    if(para[i][1] == para[i][1]){ //重合
                        isEqualLine[i] = true;
                        break;//待添加的直线是一条重边，退出循环
                    }else continue; //不重合，只是平行
                }
                crossPoint.x = (para[j][1] - para[i][1]) / (para[i][0] - para[j][0]); //y = k1*x + b1; y = k2*x + b2; 交点横坐标是 (b2 - b1)/(k1 - k2)
                crossPoint.y = para[i][0] * crossPoint.x + para[i][1];
                points.add(crossPoint); //把交点放进去
            }


            //若当前边不是重边
            if(! isEqualLine[i]) ans+=points.size() + 1;
        }

    }

    public static void output() {
        sc.close();
        System.out.println(ans+1);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
