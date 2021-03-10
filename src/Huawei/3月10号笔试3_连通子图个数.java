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
        for (int i = 0; i < n; i++) {
            label[i] = 0;
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(String.valueOf(str[i].charAt(j)));
            }
        }
        int sum =0;
        for (int i = 0; i < n; i++) {
            if(label[i]!=1){
                dfs(i,n,label,m);
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static void dfs(int i, int n, int[] label, int[][] matrix){
        label[i] = 1;
        for (int j = 0; j <n ; j++) {
            if(matrix[i][j]==1&&label[j]!=1) dfs(j,n,label,matrix);
        }
    }
}
