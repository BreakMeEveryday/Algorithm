/**
 * @Author: 李云鹏
 * @Date: 2021/6/6 9:59
 * @Version: 1.0
 */

import java.util.*;

class valCon{ //value and count
    int value;
    int count;

    public valCon(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class zeal_4 {
    static int n; //序列长度
    static int q; //询问个数
    static int[] a;
    static int[] ans;
    static Set<Integer> set = new HashSet<>(); //记录有多少种股票代码
    static Map<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>(); //hashMap(R, <val, count>)
    public static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        a = new int[n+1];   //股票代码序列
        ans = new int[q+1]; //答案
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
            set.add(a[i]);
        }

        solve();

        int L,R,k;
        for(int i = 1; i <= q; i++){ //对应q行询问
            L = sc.nextInt();
            R = sc.nextInt();
            k = sc.nextInt();
            ans[i] = answerOfQuestion(L,R,k);
        }
        sc.close();
    }

    public static int answerOfQuestion(int L, int R, int k){
        int ans = hashMap.get(R).get(k) - hashMap.get(L).get(k) + 1;
        return ans;
    }

    /**
     * 使用打表算法，将序列中，[1,R]区间的每个元素出现的个数都记录下来
     * */
    public static void solve() {
        hashMap.put(0, new HashMap<Integer, Integer>());
        for(int R = 1; R <= n; R++){
//            valCon valC = hashMap.get(R-1);
//            int temp;
//            if(valC == null) temp = 0;
//            int temp = hashMap.get(R-1).count+1;
//            hashMap.put(R,new valCon(a[R],temp);
            HashMap<Integer, Integer> h = new HashMap<>();
            h.put(a[R], hashMap.get(R-1).getOrDefault(a[R],0)+1);
            hashMap.put(R, h);
        }
    }

    public static void output() {
        for(int i = 1; i <= q; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
