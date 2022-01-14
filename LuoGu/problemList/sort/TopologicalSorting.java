package problemList.sort;/**
 * @Author: 李云鹏
 * @Date: 2021/4/15 9:54
 * @Version: 1.0
 */

//import java.util.*;

import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

/**
 * 拓扑排序
 * 应用范围，先修课的选择
 * */
public class TopologicalSorting {
    /*
    * T:输入数据组数
    * n:课程总数量
    * m:关系的数量
    * (u,v): u是v的前置课程
    * */
    static int T, n, m, u, v;
    static int[] deg = new int[100005]; //结点i的入度
    static boolean[] vis = new boolean[100005];
    static Vector<Integer>[] g = new Vector[100005];
    static Vector<String> ans = new Vector<>();
    static Queue<Integer> q = new LinkedList<>(); //队列q

    public static boolean topoSort(){
        int num = 0; //已经排好序的点个数
        while(! q.isEmpty()){
            int now = q.poll();
//            int now = q.peek();
//            q.poll();
            num++;
            for(int to : g[now]){
                if(vis[to]) continue;
                else{
                    deg[to]--; //入度减1
                    if(0 == deg[to]){//入度减为0
                        vis[to] = true;
                        q.add(to);
                    }
                }
            }
        }

        return num == n; //都入队了，返回true
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- != 0){
            Arrays.fill(deg, 0);
            Arrays.fill(vis, false);
            for(int i = 1; i <= 100000; i++){
                g[i] = new Vector<>();
                g[i].clear(); //清空邻接表
            }
            //以上是初始化
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 1; i <= m ;i++){
                u = sc.nextInt();
                v = sc.nextInt();
                g[u].add(v); //v放入u的邻接表
                deg[v]++; //入度加1
            }
            for(int i = 1; i <= n; i++){
                if(0 == deg[i]){
                    vis[i] = true;
                    q.add(i); //将一开始入度就为0的点放入队列
                }
            }
//            if(topoSort()) System.out.println("Correct");
//            else System.out.println("Wrong");
            if(topoSort()) ans.add("Correct");
            else ans.add("Wrong");
        }
        sc.close();
    }

    public static void solve() {

    }

    public static void output() {
        for(String s : ans){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
