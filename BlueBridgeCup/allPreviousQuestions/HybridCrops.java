package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/15 15:14
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class From{ //这种植物能从哪两种植物杂交得到
    int father;
    int mother;

    public From(int father, int mother) {
        this.father = father;
        this.mother = mother;
    }
}

public class HybridCrops {
    /*
    * N种作物
    * 初始有M种作物种子，但数量无限，可支持多次杂交，同时可以进行多个杂交过程
    * K表示可以杂交的方案数
    * T表示目标种子的编号
    * 输入：
    * 第一行N，M，K，T
    * 第二行：N个整数，第i个表示第i种植物的种植时间Ti
    * 第三行：M个整数，已拥有的作物类型，两两不同
    * 第四行：一行3个整数，表示A+B->C，可以得到的作物类型
    *
    * 有点像考察拓扑排序
    * */
    static int N,M,K,T;
    static Vector<Integer> time; //种植时间
    static Vector<Integer> cost; //花费的总时间
    static Vector<Vector<From>> hybrid;

    public static void dfs(Vector<Integer> cost, Vector<Vector<From>> hybrid, Vector<Integer> time, int target){
        for(int i = 0; i < hybrid.get(target).size(); i++){
            int father = hybrid.get(target).get(i).father;
            int mother = hybrid.get(target).get(i).mother;
            if(cost.get(father) == Integer.MAX_VALUE){
                dfs(cost, hybrid, time, father);
            }
            if(cost.get(mother) == Integer.MAX_VALUE){
                dfs(cost, hybrid, time, mother);
            }
            int t = Math.min(
                    cost.get(target),
                    Math.max(
                            time.get(father),
                            time.get(mother)
                    )+Math.max(
                            cost.get(father),
                            cost.get(mother)
                    )
            );
            cost.set(target, t);
        }
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        T = sc.nextInt();
        time = new Vector(N+1);
//        cost = new Vector(N+1, Integer.MAX_VALUE);
        cost = new Vector();
        for(int i = 0; i < N+1; i++){
            cost.add(Integer.MAX_VALUE);
        }

        for(int i = 1; i <= N; i++){
            time.add(sc.nextInt());
        }

        int tmp;
        for(int i = 0; i < M; i++){ //此处从0开始，因为最后一种作物只要求得到而已
            tmp = sc.nextInt();
            cost.set(tmp, 0);
        }

        int a,b,c;
        hybrid = new Vector<>(); //杂交方案分别是，这里是倒着存的
        for(int i = 0; i < N+1; i++){
            hybrid.add(new Vector<From>());
        }

        for(int i = 0; i < K; ++i){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            From from = new From(a,b);
            hybrid.get(c).add(from);
        }
        sc.close();
    }

    public static void solve() {
        dfs(cost, hybrid, time, T);
    }

    public static void output() {
        System.out.println(cost.get(T));
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
