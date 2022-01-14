package unionFind;/**
 * @Author: 李云鹏
 * @Date: 2021/4/17 9:49
 * @Version: 1.0
 */

import java.util.Scanner;
/**
 * 基础并查集
 * 
 * */
public class BasicUnionFind {
    static int MAXN = 100;
    static int n = 6;
    static int[] fa = new int[MAXN]; //father，表示根父节点

    public static void init(int n){ //初始化并查集
        for(int i = 1; i <= n; i++){
            fa[i] = i; //一开始，父节点都是自己
        }
    }

    public static int find(int x){
        /**
         * 以下是未经优化的并查集的查找根节点，要一步一步往上找
         * */
//        if(fa[x] == x) return x; //根节点是自身
//        else return find(fa[x]);

        /**
         * 优化之后，直接将每个节点的父节点设为根节点
         * */

        if(x == fa[x]) return x;
        else{
            fa[x] = find(fa[x]); //类似记忆化
            return fa[x];
        }
    }

    public static void mergeTo(int i, int j){
        fa[find(i)] = find(j); //将i的父节点合并至j的父节点
    }



    public static void input() {
        Scanner sc = new Scanner(System.in);
//        MAXN = sc.nextInt();

        sc.close();
    }

    public static void solve() {
        init(n);
        mergeTo(3,1);
        mergeTo(2,3);
        mergeTo(5,4);
        mergeTo(6,5);
        mergeTo(4,1);
    }

    public static void output() {
        for(int i = 1; i <= n; i++){
            System.out.println(i+"的父节点是"+find(i));
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
