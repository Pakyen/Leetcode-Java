package NowcoderAliTest;

import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-14 5:08 PM
 */
/*
source: https://www.nowcoder.com/questionTerminal/3b6dc1447d6d4ac4b9c2d45f1d4637ea
ac100
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            String[] value = in.nextLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            int n = Integer.parseInt(value[2]);
            System.out.println(calculateN(a,b,n));
        }

    }
    // 0 <= a,b <= 1e9+7
    private static long calculateN(int a, int b, int n){
        if(n<2) return n==0 ? 2:a;
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 2;
        dp[1] = a;
        for (int i = 2; i <= n; i++) {
            //记得要加上mod再取余
            dp[i] = (dp[i-1]*a %mod - b*dp[i-2] %mod + mod)%mod;
        }
        return dp[n];
    }
}
