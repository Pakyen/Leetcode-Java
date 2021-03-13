/*
美团笔试1 懒惰的小美

给定n,m
一个nxm的二维数组，沿着aii开始反转

竖着输入即可
 */
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                arr[j][i] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j<n-1){
                    System.out.print(Integer.toString(arr[i][j])+' ');
                }else{
                    System.out.println(Integer.toString(arr[i][j]));
                }
            }
        }
    }
}
