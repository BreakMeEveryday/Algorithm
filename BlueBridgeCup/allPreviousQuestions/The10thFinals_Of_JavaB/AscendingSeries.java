package allPreviousQuestions.The10thFinals_Of_JavaB;/**
 * @Author: 李云鹏
 * @Date: 2021/4/16 8:12
 * @Version: 1.0
 */

import java.io.*;
import java.util.Scanner;
/**
 * 递增序列
 *对于一个字母矩阵，我们称矩阵中的一个递增序列是指在矩阵中找到两个
 * 字母，它们在同一行，同一列，或者在同一 45 度的斜线上，这两个字母从左向
 * 右看、或者从上向下看是递增的。
 * 例如，如下矩阵中
 *
 * LANN
 * QIAO
 *
 * 有LN、LN、AN、AN、IO、AO、LQ、AI、NO、NO、AQ、IN、AN 等 13 个
 * 递增序列。注意当两个字母是从左下到右上排列时，从左向右看和从上向下看
 * 是不同的顺序。
 * 对于下面的 30 行 50 列的矩阵，请问总共有多少个递增序列？（如果你把
 * 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
 * 试题目录下有一个文件 inc.txt，内容与下面的文本相同）
VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG
SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF
ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA
BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL
YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH
ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU
XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR
ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG
MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA
VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF
GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC
EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK
PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW
CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP
RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS
PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR
JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL
YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP
HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN
DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF
LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW
CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ
IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI
ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB
HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP
FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS
VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ
BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR
RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY
ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX

 * 答案：52800
 * */
public class AscendingSeries {
    static int n;
    static char[][] cs = new char[30][]; //存储文本的char矩阵


    public static boolean inMap(int x, int y){
        return 0 <= x && x < cs.length && 0 <= y && y < cs[x].length;
    }

    public static void input() throws IOException {
        //读取文件的写法
        BufferedReader br = new BufferedReader(new FileReader(new File("E:\\all Kinds Of File\\Java\\IntelljProject\\Algorithm\\BlueBridgeCup\\allPreviousQuestions\\The10thFinals_Of_JavaB\\inc.txt")));
        int nowRow = 0;
        String line;
        while((line = br.readLine()) != null){
            cs[nowRow++] = line.toCharArray();
        }
    }

    public static void solve() {
        int[][] dir = {
                {1,0},
                {0,1},
                {1,1},
                {1,-1},
                {-1,1}
        };//5种可行的方向

        int cnt = 0;
        //遍历矩阵的每一个位置，然后向5个方向查找
        for(int i = 0; i < cs.length; i++){
            for(int j = 0; j < cs[i].length; j++){
                char c = cs[i][j];
                for(int k = 0; k < 5; k++){
                    int x = i;
                    int y = j;//记录当前字符的位置，然后进行遍历搜索
                    while(true){
                        x += dir[k][0];
                        y += dir[k][1];
                        if(!inMap(x,y)) break; //跳出本层循环

                        if(cs[x][y] > c) cnt++;
                        //只要有一个符合条件，都要计入，比如ab，ac算不同的两个，而且这里只要求两个字母，并不是递增子序列的题

                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void output() {

    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }
}
