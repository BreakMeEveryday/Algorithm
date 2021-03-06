package problemList.sequentialStructure;

import java.math.BigInteger;
import java.util.Scanner;


public class Diagonal {
    public static void main(String[] args) {
//        int n;
//        Scanner sc = new Scanner(System.in);
//        //四个顶点可以构成两条对角线，形成一个交点
//        n = sc.nextInt();
//        String s =  String.valueOf(n*(n-1)/2 * (n-2)/3 * (n-3)/4);//n*(n-1)/2 * (n-2)/3 * (n-3)/4
//        BigInteger ans = new BigInteger(s);
//        System.out.println(ans);

//        BigInteger n = new BigInteger("0");
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());
//        System.out.println(n.add(new BigInteger("-1")));
        BigInteger ans = n.and(n.add(new BigInteger("-1")));
//                          .and(n.add(new BigInteger("-2")));
//                          .and(n.add(new BigInteger("-3")));
        System.out.println(ans);
    }
}

/*
* 对角线
* P2181
*
* 题解：
* 首先由于不会有三条对角线交于一点，所以过某一个交点有且只能有２条对角线

而这两条对角线实质上是确定了４个顶点（也可以看做是一个四边形的两条对角线交于一点，求四边形的数量）。

因此我们只需要确定４个顶点就得到了这个唯一确定的交点。

因此我们只需要求这样４个顶点的搭配有多少个了

也就是从ｎ个顶点中取４个出来。

根据组合数的公式，（如果你不知道组合数的公式可以这么推：第一次取可以ｎ个点都是可以取的，
第二次取的时候第一个取的点就不能取了，所以只能取(n-1)种，以此类推）

由于改变四个点的顺序不会改变对角线，因此是求的组合而不是排列，也就要除以４！，也就是２４

于是我们就得到了公式： n * (n-1) * (n-2) * (n-3) / 24

同时为了防止爆掉，但又不想写高精，

我们可以采用一种化简的技巧

于是原式可以化为:

n * (n-1) / 2 * (n-2) / 3 * (n-3) / 4

那为什么这样一定是对的呢？难道不会因为除不尽却向下取整而导致错误吗？

事实上是一定除得尽的

首先n和n-1一定有一个是２的倍数，因此２可以除尽，

同理n,n-1,n-2中一定有一个是３的倍数，因此３可以除尽（除掉２只会消除因数２而对３没有影响）

同理４也可以除尽

完＼（＾ｏ＾）／～
* */