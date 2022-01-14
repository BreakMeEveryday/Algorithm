package problemList.lineSegmentTrees_and_TreeArrays;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 线段树的实现
 * P3372
 * */
public class LineSegmentTree {
    static int n,m;
    static int MAXN = 1_000_000;
    static int[] nums = new int[MAXN];
    static int[] ans = new int[MAXN<<2];
    static int[] tag = new int[MAXN<<2]; //这种2的幂次方的乘法可以移位操作
    //tag作用？

    /*
    * 取左儿子结点
    * */
    public static int leftSon(int parent){
        return parent<<1;
    }

    /*
     * 取右儿子结点
     * */
    public static int rightSon(int parent){ //右儿子结点
        return parent<<1|1;// == parent<<1 + 1
    }


    public static void pushUp(int parent){
        ans[parent] = ans[leftSon(parent)] + ans[rightSon(parent)];
    }

    public static void pushUpMin(int parent){//or Max
//        t[parent] = Math.min(leftSon(parent), rightSon(parent));
    }

    public static void build(int parent, int left, int right){ //数组下标只能是int或比int更小的
        if(left == right){
            ans[parent] = ans[left];
            return;
        }

        int mid = (left - right)>>1 + right;//防止越界
        build(leftSon(parent), left, mid);
        build(rightSon(parent), mid, right);
        pushUp(ans[parent]);
    }

    public static void f(int parent, int left, int right, int k){
        tag[parent] = tag[parent] + k;
        ans[parent] = ans[parent] + k*(right-left+1);
    }

    public static void pushDown(int parent, int left, int right){
        int mid = (left - right)>>1 + right;
        f(parent,left,right,tag[parent]); //tag是用来记录k的吗？

    }

    /*
    * [nowLeft, nowRight]为现在要修改的区间
    * left, right, parent为当前节点所存储的区间及节点的编号
    * */
    public static void update(int nowLeft, int nowRight, int left, int right, int parent, int k){
        if(nowLeft <= left && right <= nowRight){
            ans[parent]+=k*(right - left + 1); //总的值增加了多少
            tag[parent]+=k;
            return;
        }
        //不完全在区间内
        pushDown(parent, left, right);
        //回溯之前（也可以说是下一次递归之前，因为没有递归就没有回溯）
        //由于是在回溯之前不断向下传递，所以自然每个节点都可以更新到
        int mid = (left - right) >> 1 + right;
        if(nowLeft <= mid) update(nowLeft, nowRight, left, mid, leftSon(parent), k);
        if(nowRight > mid) update(nowLeft, nowRight, mid+1, right, rightSon(parent), k);
        pushUp(parent);

    }

    public static int query(int q_x, int q_y, int left, int right, int parent){
        int res = 0;
        if (q_x <= left && right <= q_y) return ans[parent];
        int mid = (left - right) >> 1 + right;
        pushDown(parent, left, right);
        if(q_x<=mid)res+=query(q_x,q_y,left,mid,leftSon(parent));
        if(q_y>mid) res+=query(q_x,q_y,mid+1,right,rightSon(parent));
        return res;
    }
    public static void input(){
        Scanner scan = new Scanner(System.in);
    }

    public static void solve(){

    }

    public static void output(){

    }
    public static void main(String[] args) {
        input();
        solve();
        output();

    }
}
