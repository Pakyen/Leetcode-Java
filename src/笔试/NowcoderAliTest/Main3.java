package NowcoderAliTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-14 5:42 PM
 */
/*
source：https://www.nowcoder.com/questionTerminal/aaefe5896cce4204b276e213e725f3ea
Ac: 100%
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] values = in.nextLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        System.out.println(numOfTrees(n,m));
    }
    public static long numOfTrees(int n, int m){
        int mod = 1000000007;
        long[][] dp = new long[n+1][m+1];
        /*
            初始化：0个节点 树的数量为1
         */
        Arrays.fill(dp[0],1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <=i-1 ; k++) {
                    //对i个节点，高度<=j的情况来说
                    //可以先排除跟节点，记得不算节点高度要-1
                    // 左子树分配k个节点，右子树分配i-k-1个节点
                    dp[i][j] = (dp[i][j] + dp[k][j-1] * dp[i-k-1][j-1] % mod) %mod;
                }
            }
        }
        return dp[n][m];
    }
}
