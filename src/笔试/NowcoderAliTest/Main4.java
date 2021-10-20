package NowcoderAliTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-18 2:55 PM
 */
/*
source: https://www.nowcoder.com/questionTerminal/ef231526f822489d879949226b4bed65
ac 100
 */
public class Main4 {
    // dx和dy是转向矩阵
    // dp[i][j][k] ：从起点走到(i，j），使用飞行器k次，的最小步数
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        char[][] map = new char[n][m];
        int sx=0,sy=0,ex=0,ey=0; //起点终点的坐标
        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
                if(ch=='S'){
                    sx = i;
                    sy = j;
                }
                if(ch=='E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        bfs(map,sx,sy,ex,ey);
        //飞行器最多使用5次
        for (int i = 0; i < 6; i++) {
            if(dp[ex][ey][i]!=0){
                System.out.println(dp[ex][ey][i]);
                return;
            }
        }
        System.out.println(-1);
    }
    public static void bfs(char[][] map, int sx, int sy, int ex, int ey){
        int n = map.length;    //行
        int m = map[0].length; //列
        Deque<int[]> queue = new ArrayDeque<>();

        // dp[i][j][k] ：从起点走到(i，j），使用飞行器t次，的最小步数
        dp = new int[n][m][6];


        queue.offerFirst(new int[] {sx, sy, 0});
        while(!queue.isEmpty()){
            //取出队列最后一个数组
            int[] status = queue.pollLast();
            int x = status[0];
            int y = status[1];
            int t = status[2];      //times
            int nx=0, ny=0, nt=0;   //下一步的坐标 or 对称传送后的坐标

            // 宽度优先搜索 对于每个位置，有5个方向：上下左右和使用飞行器
            // 每到达一个位置，判断有无越界，是否碰到障碍物，是否飞行器使用次数超限，下一个位置dp是否为0
            // 如果下一个位置dp为0，则dp[nx][ny][nt] = 原位置dp+1
            // 因为在层次遍历的过程中，都是从近的地方慢慢往远走，如果下一个位置的dp!=0，说明这个位置已经在前面的遍历中走过了。所以就可以不用再走了
            for (int i = 0; i < 5; i++) {
                // i = [0,3] 使用控制矩阵上下左右走
                // i = 4 使用飞行器
                if(i<4){
                    nx = x + dx[i];
                    ny = y + dy[i];
                    nt = t;             //为什么不加1？ 因为t不是步数，是使用飞行器的次数
                }else{
                    nx = n - 1 - x;     //题目从1开始 这里记录坐标从0开始 所以-1
                    ny = m - 1 - y;
                    nt = t + 1;
                }
                boolean condition = nx>=0 && nx<n && ny>=0 && ny<m && nt<6 && map[nx][ny]!='#' && dp[nx][ny][nt]==0;

                if(condition){
                    dp[nx][ny][nt] = dp[x][y][t] + 1;
                    if(nx==ex && ny==ey){
                        return;
                    }
                    queue.offerFirst(new int[] {nx,ny,nt}); //通过往队列加坐标来遍历所有情况
                }
            }
        }

    }
}
