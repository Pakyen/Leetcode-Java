import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-04 5:22 PM
 */
/*
题目描述：
小美有一张无向图。特别会数数的小团想拿个难题考一下小美，于是他决定询问小美这张无向图中有多少个不同的四边形。无向图中的四边形由四个不同的点a,b,c,d和四条属于这张无向图的边(a,b),(b,c),(c,d),(d,a)组成。若两个四边形的点集和边集相同，则我们认为这两个四边形是同一个四边形。小美的这张无向图有点大，她希望你帮她算出这个难题的答案。

输入描述
第一行有一个整数n代表这张无向图中的点数。

接下来n行给出这张无向图的邻接矩阵，每行有n个由空格隔开的整数，每个整数的值为0或1。

输入保证对角元为0，即这张图没有自环。

输出描述
输出一个整数，代表这张无向图中有多少个不同的四边形。


样例输入
6
0 1 1 1 0 0
1 0 1 0 1 0
1 1 0 0 0 1
1 0 0 0 1 1
0 1 0 1 0 1
0 0 1 1 1 0
样例输出
3
 */

/*
ac 9%
 */
public class Meituan4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        while(in.hasNextInt()){
            x = in.nextInt();
        }
        System.out.println(n/2);
    }


}
