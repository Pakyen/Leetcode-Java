import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-07 11:22 PM
 */
/*
像素

放大图像：保持像素排列，平均增加每个像素的数量
 */
public class Baidu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n*k; i++) {
            for (int j = 0; j < n*k; j++) {
                int x = i / k;
                int y = j / k;
                System.out.print(dp[x][y]+ " ");
            }
            System.out.println();
        }
    }
}
