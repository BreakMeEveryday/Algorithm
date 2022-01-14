//package Month4.blueBridge.PreProblems;
//
//import java.util.Scanner;
//
//public class AntsOfLanDun {//兰顿蚂蚁
//    private static String dir = "URDL";
//    private static int[][] map;
//
//    public static void input(){
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        map = new int[m][n];
//        for(int i = 0; i < m; i++){
//            for(int  j = 0; j < n; j++){
//                map[i][j] = sc.nextInt(); //0是白格，1是黑格
//            }
//        }
//
//        int x = sc.nextInt();
//        int y = sc.nextInt();//(x,y)是蚂蚁所在初始位置
//        char c = sc.next().charAt(0); //初始朝向
//        int k = sc.nextInt(); //步数
//        sc.close();
//        walk(x,y,c,k);
//    }
//
//    private static void walk(int x, int y, char c, int k){
//        if(0 == k){
//            System.out.println(x + " " + y);
//            return;
//        }
//        c = getNext(c,x,y);
//        switch (c){
//            case 'U':
//                x-=1;
//                break;
//            case 'R':
//                y+=1;
//                break;
//            case 'D':
//                x+=1;
//                break;
//            case 'L':
//                y-=1;
//                break;
//        }
//        walk(x,y,c,k-1);
//    }
//
//    private static char getNext(char c, int x, int y){
//        int index = dir.indexOf(c);//URDL中位于第几个
//        if(map[x][y] == 1){//黑格，右转90度
//            index++;
//            index %= 4; //四个方向来回转，不能越过这4个方向
//            map[x][y] = 0; //变白格
//        }else{
//            index--;
//            if(index == -1) index = dir.length() - 1;
//            map[x][y] = 1; //变黑格
//        }
//        return dir.charAt(index);
//    }
//
//    public static void solve(){
//
//    }
//    public static void output(){
//
//    }
//    public static void main(String[] args) {
//        input();
//        solve();
//        output();
//    }
//}
















package allPreviousQuestions;

import java.util.Scanner;

public class AntsOfLanDun{
    static int m,n;//正方形格子的行数与列数
    static int[][] map;
    static String dir = "URDL";
    public static void input(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int x,y,k;//蚂蚁所在行号，列号，朝向，步数
        char s;
        x = sc.nextInt();
        y = sc.nextInt();
        s = sc.next().charAt(0);
        k = sc.nextInt();
        solve(x,y,s,k);
    }

    public static void solve(int x, int y, char s, int k){
        walk(x,y,s,k);
    }

    public static void walk(int x, int y, char s, int k){
        if(0 == k){
            System.out.println(x+" "+y); //输出最终位置
            return ;
        }

        int index = dir.indexOf(s); //找到当前朝向在dir中的位置
        if(map[x][y] == 1){ //黑格
            index++;
            if(index == 4){            //转了一圈朝上
                index = 0;
            }
            map[x][y] = 0;
            s = dir.charAt(index);
//            s = dir.substring(index,index);
        }else{ //白格
            index--;
            if(-1 == index){
                index = dir.length()-1;
            }
            map[x][y] = 1;
            s = dir.charAt(index);
//            s = dir.substring(index,index);
        }

        switch (s){
            case 'U':
                x--;
                break;
            case 'R':
                y++;
                break;
            case 'D':
                x++;
                break;
            case 'L':
                y--;
                break;
        }
        walk(x,y,s,k-1);
    }

    public static void output(){

    }

    public static void main(String[] args) {
        input(); //input调用了solve
    }
}