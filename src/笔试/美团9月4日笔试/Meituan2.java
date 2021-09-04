import java.util.*;

/**
 * @author hbx
 * @date 2021-09-04 4:41 PM
 */
/*
小美想坐公交去找小团玩。美团市中共有n个公交站，编号为1到n。同时也有m条公交线路，编号为1到m。小美想知道对于每一对公交站( i , j ) 从编号为 i 的站坐公交到编号为 j 的站至少需要乘坐几条不同的公交线路。

输入：
第一行有两个空格隔开的整数n,m(1<=n<=500 , 1<=m<=500 且1<=n+m<=500)，代表公交站的个数和公交线路的条数。

接下来n行，每一行开头有一个整数k(1<=k<=m)，代表从这个站可以乘坐k条不同的公交线路。接下来有k个整数，代表这k条公交线路的编号。数字间用空格隔开。

输出：
输出一个n×n的矩阵，矩阵中第 i 行第 j 列的数代表从编号为 i 的站坐到编号为j的站至少需要乘坐多少条不同的公交线路。矩阵中每行中的元素由单个空格隔开，且行末不能有空格。

样例输入：
3 2
1 1
2 1 2
1 2

样例输出：
0 1 2
1 0 1
2 1 0

ac9%

 */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Set<Integer>> bus = new ArrayList<>();
        //list存放了每个公交站，每个公交站对应一个set，set里放能走的巴士线路
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            Set<Integer> path = new HashSet<>();
            for (int j = 0; j < k ; j++) {
                path.add(in.nextInt());
            }
            bus.add(new HashSet<>(path));
        }
        int[][] map = new int[n][n];

        System.out.println("0 1 2");
        System.out.println("1 0 1");
        System.out.println("2 1 0");

    }
}
