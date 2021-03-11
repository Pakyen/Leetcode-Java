import java.util.Scanner;
/*
华为3. 最大连通子图个数

N个广播站
给一个矩阵 matrix[i][j]=1表示两个节点连通
matrix[i][j]=0表示两个节点之间没有连接

其中：matrix[i][i]=1, matrix[i][j] = matrix[j][i]

问：发送一条广播，初始最少需要给几个广播站发送，才能保证所有的广播站都收到消息

其实就是考连通子图的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int n = str.length;
        int[][] m = new int[n][n];
        int[] label = new int[n]; //n个节点，记录图中节点有没有被访问过
        //将输入保存为二维数组
        for (int i = 0; i < n; i++) {
            label[i] = 0;
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(String.valueOf(str[i].charAt(j)));
            }
        }
        int sum =0;
        //记录子图个数
        for (int i = 0; i < n; i++) {
            //对于所有节点来说，如果节点没有被访问过，就进行一次dfs，将路径上所有节点标记为访问过
            //一次dfs，其实就是一条访问路径，也就是一个连通子图
            if(label[i]!=1){
                dfs(i,n,label,m);
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static void dfs(int i, int n, int[] label, int[][] matrix){
        //对节点i来说，进行DFS
        //将节点i的label标为1，证明访问过了
        //继续访问所有和i连接的节点j，如果j没有被访问过，那么就继续dfs遍历，将遇到的节点都标志为1
        //直到从i开始的所有路径都被访问过为止
        label[i] = 1;
        for (int j = 0; j <n ; j++) {
            if(matrix[i][j]==1&&label[j]!=1) dfs(j,n,label,matrix);
        }
    }
}
