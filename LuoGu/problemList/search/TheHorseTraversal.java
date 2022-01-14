package problemList.search;

import java.util.*;

/*
* 马的遍历
* P1443
* */
class Node{
    int x;
    int y;
}


public class TheHorseTraversal {
    static int n,m;//地图大小
    static int x,y;//马的初始坐标
    static int[] dx = {1,-1,2,-2};
    static int[] dy = {1,-1,2,-2}; //乘出来会有16个方向通过绝对值的判断，去除8个方向
    static int[][] map = new int[401][401];//记录每个点的到达所需的步数
    static boolean[][] notInQueue = new boolean[401][401]; //入队标记



    public static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                notInQueue[i][j] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            Arrays.fill(map[i], -1);
        }

        sc.close();
        bfs(x, y, 0); //题目中的计数是从1开始的
    }

    public static void solve(){
		
    }

    public static boolean inMap(int x, int y){
        return 1<=x && x<=n && 1<=y && y<=m;
    }

    public static void bfs(int x, int y, int step){ //由于要采用队列，将坐标入栈，所以需要写一个结点类
        map[x][y] = step;
        notInQueue[x][y] = false; //已入队
        Queue<Node> queue = new LinkedList<Node>();//Queue是接口，LinkedList才是实现类

        Node node = new Node();
        node.x = x;
        node.y = y;
        queue.add(node);
        while(!queue.isEmpty()){
            Node top = queue.peek(); //返回队列头但不删除
            queue.remove(); //删除队列头
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(Math.abs(dx[i]) != Math.abs(dy[j])){ //满足这个条件的才是马的真是方向，get到了!
                        int nextX = top.x + dx[i];
                        int nextY = top.y + dy[j];
//                        if(inMap(nextX, nextY)){
                            //使用boolean数组保证每个点只入队一次，时间复杂度降低
                            if(! inMap(nextX, nextY)) continue;

                            if (notInQueue[nextX][nextY]){ //其实就是访问标志位，访问了就入队了
                                Node node1 = new Node(); //此处入队的问题，与java面向对象的特性相关，必须使用新的node结点
                                node1.x = nextX;
                                node1.y = nextY;
                                queue.add(node1);
                                notInQueue[nextX][nextY] = false;//已经入队
                                map[nextX][nextY] = map[top.x][top.y]+1;//步数加1
                            }
//                        }
                    }
                }
            }
        }
    }

    public static void output(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                System.out.printf("%d    ",map[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        input();
        solve();
//        bfs(x, y, 0); //题目中的计数是从1开始的
        output();
    }
}


/*
* 0    3    2    3    2    3    4    5    4
3    4    1    2    3    4    3    4    5
2    1    4    3    2    3    4    5    4
3    2    3    2    3    4    3    4    5
2    3    2    3    4    3    4    5    4
3    4    3    4    3    4    5    4    5
* */