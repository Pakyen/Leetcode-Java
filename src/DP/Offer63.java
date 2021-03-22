package DP;

public class Offer63 {
//public class Solution{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cost =Integer.MAX_VALUE, profit = 0;
        //dp[0] = 0
        //dp[i] = max( dp[i-1], prices[i] - min(prices[0:i]) )
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, prices[i] - (cost = cost<prices[i]? cost: prices[i]));
        }
        return profit;
    }

}
