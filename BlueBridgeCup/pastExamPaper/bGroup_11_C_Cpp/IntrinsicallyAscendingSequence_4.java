package pastExamPaper.bGroup_11_C_Cpp;/**
 * @Author: 李云鹏
 * @Date: 2021/6/1 21:03
 * @Version: 1.0
 */

import java.util.Arrays;
import java.util.Scanner;
/**
 * 第4题，本质上升序列
 * */
public class IntrinsicallyAscendingSequence_4 {
    static int n;
    static String s = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
//    static String s = "012132";
    static int[] dp = new int[201]; //s.length() == 200

    /**
     * 思路，采用DP
     * 建立dp数组dp[],dp[i]表示，以s[i]结尾的本质上升子序列的个数
     * */
    public static void solve() {
        Arrays.fill(dp, 1);//因为每个字符本身也算作本质上升子序列
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(j) < s.charAt(i)) dp[i] = dp[i] + dp[j];
                if(s.charAt(j) == s.charAt(i)) dp[i] = dp[i] - dp[j]; //举例，122中,12(第二个2),12(第三个2)，本质上就是一个上升序列，所以需要减掉
            }
        }
    }

    public static void output() {
        int ans = 0;
        for(int i = 0; i < 200; i++){
//            System.out.print(dp[i]+" ");
            ans += dp[i];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
        output();
    }
}
