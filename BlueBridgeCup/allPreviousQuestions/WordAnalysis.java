package allPreviousQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordAnalysis { //单词分析
    /*
    * 给了一个单词后，帮助他找到出现最多的字母和这个字母出现的次数。
    * */
    static String word;
    public static void input(){
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine(); //读取一行
    }
    public static void solve(){
        //使用Hash表，构建一个26容量的HashMap,
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            Integer num =hashMap.get(c); //获得字符c的数量
            if(num == null){ //这是一开始还未添加进hashMap做的准备
                hashMap.put(c, 1);
            }else{
                hashMap.put(c, ++num);
                //num++和num+1的效果在这里是不等价的？？编译器有问题？没有问题，num++是后加操作，把
                //++放在num前面就可以达到效果
            }
        }

        char ch = ' '; //空格字符
        int ansNum = Integer.MIN_VALUE; //对应字符的答案数量
        for(Map.Entry<Character, Integer> record: hashMap.entrySet()){//entrySet的作用?
            //record是一个键值对
            int num = record.getValue();
            if(num > ansNum){
                ansNum = num;
                ch = record.getKey();
            }
//            System.out.println(record.toString());

        }
        System.out.println(ch);
        System.out.println(ansNum);

    }
    public static void output(){

    }
    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
