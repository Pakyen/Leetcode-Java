import java.util.Scanner;

/*
京东3月27笔试2 防水板砖

 在X星的一片建筑工地上堆放着很多防水板砖，它们每一块的规格都一模一样，但是每一叠都高矮不一，这些砖块堆放得非常整齐而且非常紧凑，紧凑到“滴水不漏”。俯视这些砖块可以得到一个n*m的矩阵。现在给你一个n*m的矩阵，第n行m列上的数字表示对应位置的板砖数量，例如下面的矩阵所示：

2 3 5 1
4 1 2 3
1 5 4 2
1 2 2 2

第1行第1列的“2”表示这个位置对应的那一叠板砖的数量为2块。

某一天突然天降暴雨。暴雨过后，在板砖区形成了很多个小水坑。如果某一叠板砖的数量比它周围前、后、左、右的板砖数量少，将形成一个小水坑。相邻的两叠或者多叠板砖可能会构成一个大一点的水坑。例如在上面的图中，两叠红色的板砖将构成一个水坑，因为它们周围上、下、左、右的板砖（蓝色板砖）的数量比它们要多。

当然，最旁边的板砖是没有办法形成小水坑的。

假如这场雨下得足够大，足以让每一水坑都装满水
 */
/*
AC100%，虽然思路是错的
 */
public class JD2 {
    public static void main(String[] args) {
        //处理输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int num = 0; //水坑数量

        for (int i = 1; i < n-1 ; i++) {
            for (int j = 1; j < m-1; j++) {
                if(arr[i][j]<arr[i-1][j]&&
                    arr[i][j]<arr[i][j-1]&&
                    arr[i][j]<arr[i+1][j]&&
                    arr[i][j]<arr[i][j+1]){
                    num+=1;
                }
            }
        }
        System.out.println(num);
    }
}
