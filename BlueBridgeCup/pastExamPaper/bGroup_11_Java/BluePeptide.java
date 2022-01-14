package pastExamPaper.bGroup_11_Java;/**
 * @Author: 李云鹏
 * @Date: 2021/6/4 13:57
 * @Version: 1.0
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 蓝肽子序列
 * Input:LanQiaoBei
 *       LanTaiXiaoQiao
 * Output:2
 * 举例:LanQiao是其最长公共子序列，2个肽
 *
 * dp[i,j] = 0;  --> i = 0 || j = 0
 * dp[i,j] = dp[i-1][j-1] + 1;  S1[i] = S2[j]
 * dp[i,j] = max(dp[i-1][j], dp[i][j-1])
 * */

public class BluePeptide {
    public static void print(int[] A){
        for(int i = 1; i < A.length; i++){
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap();
        String Astr = in.readLine(); //字符串A
        String Bstr = in.readLine(); //字符串B

        //n,m,cur的意义？
        int n = 1, m = 1, cur = 1;
        int[] A = new int[1024];
        int[] B = new int[1024];
        Integer val;
        String key;

        //交换两个字符串，使字符串A的长度更小
        if (Astr.length() > Bstr.length()) {
            String t = Bstr;
            Bstr = Astr;
            Astr = t;
        }

        /**
         * 以下两段代码相同，意义是
         * A中循环cur的意义是，该子字符串第一次出现的位置
         * */
        for (int start = 0, end, high = Astr.length(); start < high; start = end) {
            end = start + 1;
            while(end < high && Astr.charAt(end) > 'Z') end++;
            key = Astr.substring(start, end); //找到了一个肽，end一直指向小写字母
            val = map.get(key);
            if (val == null)
                map.put(key, val = cur++);    //记录字符串key在A字符串中出现的个数
            A[n++] = val; //关键的一句话
        }

//        print(A);
//        System.out.println();

        for (int start = 0, end, high = Bstr.length(); start < high; start = end) {
            end = start + 1;
            while(end < high && Bstr.charAt(end) > 'Z') end++;
            key = Bstr.substring(start, end);
            val = map.get(key);

            //与A中的for循环有区别，B[m]的意思是在A中出现过的字符串，在A中的第一次出现的位置
            /*
              如
              Astr = LanTaiQiao
              Bstr = BeiTaiLanQiao
              A = 1 2 3
              B = 2 1 3
              A是一个递增的序列，B是在Bstr中将这个序列重新按照Bstr的顺序排一遍，
              找其中的最长公共子序列即可
            * */
            if (val != null)
                B[m++] = val;
        }

        /*
         * dp[i,j] = 0;  --> i = 0 || j = 0
         * dp[i,j] = dp[i-1][j-1] + 1;  S1[i] = S2[j]
         * dp[i,j] = max(dp[i-1][j], dp[i][j-1])
        * */

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : max(dp[i - 1][j], dp[i][j - 1]);
                //dp[0][j] 和 dp[i][0]的值在创建时就有，被隐含了
        System.out.println(dp[n][m] - 1);
    }
    static int max(int a, int b) { return a > b ? a : b; }
}