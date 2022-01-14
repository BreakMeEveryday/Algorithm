package allPreviousQuestions;/**
 * @Author: 李云鹏
 * @Date: 2021/4/15 19:43
 * @Version: 1.0
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 子串分值
 * */
public class Value_Of_SubString {
    static int n;
    static String line;
    static ArrayList<Integer>[] lists = new ArrayList[26]; //用list存放26个字母出现的索引，相当于一个二维数组

    public static void input() {
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
            lists[i].add(-1); //所有字符第一次出现的索引看作-1
        }
        sc.close();
    }

    public static void solve() {
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            lists[c-'a'].add(i); //将索引存进去
        }
        BigInteger bi = new BigInteger("0");
        for(int i = 0; i < 26; i++){
            if(1 == lists[i].size()) continue; //字符没有出现过，没有贡献

            lists[i].add(line.length());//???
            long pre = -1;
            long cur = lists[i].get(1);//字母(i+'a')第一次出现的位置
            for(int j = 2; j < lists[i].size(); j++){
                long next = lists[i].get(j); //字母(i+'a')第j次出现的位置
                bi = bi.add(BigInteger.valueOf((cur - pre)*(next - cur)));//???什么意思？
                pre = cur;
                cur = next;
            }
        }
        System.out.println(bi);
    }

    public static void output() {
        for(int i = 0; i < lists[0].size(); i++){
            System.out.print(lists[0].get(i)+" ");
        }
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
