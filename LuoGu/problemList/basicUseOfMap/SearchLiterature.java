package problemList.basicUseOfMap;/**
 * @Author: 李云鹏
 * @Date: 2021/4/17 9:32
 * @Version: 1.0
 */

import java.util.Scanner;
import java.util.Vector;

/**
 * 查找文献
 * */

class Edge{
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class SearchLiterature {
    static int n;
    static Vector<Integer>[] e = new Vector[100001]; //存储具体信息的二维Vector
    static Vector<Edge> s = new Vector<>();

    public static boolean cmp(Edge x, Edge y){
        if(x.v == y.v) //v相同按u排序
            return x.u < y.u;
        else return x.v < y.v; //不同按v排序
    }

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
        input();
        solve();
        output();
    }
}
