package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/1 19:23
 * @Version: 1.0
 */

import java.util.*;

/**
 * 扩散，第2题，这道题自己算的答案和标答没对上，看看哪里错了。
 * */

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Diffusion_2 {
    static int n = 2020;
    static long ans = 0;
    static int[][] map = new int[6200][6200];
    static int[][] dir = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public static void ini() {
        map[0+2030][0+2030] = 1;
        map[2020+2030][11+2030] = 1;
        map[11+2030][14+2030] = 1;
        map[2020+2030][2020+2030] = 1; //将坐标点平移
    }

    public static void solve() {
        //采用BFS算法
        Queue<Point> queue = new LinkedList<>();
        Point point1 = new Point(0+2030,0+2030);
        Point point2 = new Point(2020+2030,11+2030);
        Point point3 = new Point(11+2030,14+2030);
        Point point4 = new Point(2020+2030,2020+2030);
        queue.add(point1);queue.add(point2);queue.add(point3);queue.add(point4);

        for(int time = 1; time <= 2020; time++){
            int cnt = queue.size();
            while(cnt > 0){
                Point p = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nextX = p.x + dir[i][0];
                    int nextY = p.y + dir[i][1];
                    Point nextP = new Point(nextX, nextY);
                    if(map[nextX][nextY] == 0){
                        ans++;
                        queue.add(nextP);
                        map[nextX][nextY] = 1;
                    }
                }
                cnt--;
            }
        }

    }

    public static void output() {
//        for(int i = 0; i < map.length; i++){
//            for(int j = 0; j < map[0].length; j++){
//                if(1 == map[i][j]) ans++;
//            }
//        }
        System.out.println(ans);//为什么答案算的是20392908？
    }

    public static void main(String[] args) {
        ini();
        solve();
        output();
    }
}
