package DP;

public class Leetcode343 {
    public int integerBreak(int n){
        //dp中存放每个子问题的最大乘积
        int[] dp = new int[n+1];
        for (int i = 2; i <=n ; i++) {
            int curMax = 0;
            //对于每个i,可以拆分为 j 和 (i-j)
            for (int j = 1; j < i ; j++) {
//                对于每个j来说，保存它的最大乘积
                int submax = Math.max(j*(i-j),j*dp[i-j]);
                //对于每个i来说，遍历j，保存i的最大乘积到curMax
                curMax = Math.max(curMax,submax);
            }
            dp[i] = curMax;
        }
        //对于n，最大乘积为：
        return dp[n];
    }

    //方法2：数学
    public int integerBreak2(int n){
        if(n<=3) return n-1;
        int a = n/3, b = n%3;
        if(b==0) return (int)Math.pow(3,a);
        if(b==1) return (int)Math.pow(3,a-1) * 4;
        return (int)Math.pow(3,a) * 2;
    }
}
