# Offer63. 股票的最大利润

## 题目描述
![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/%E6%88%AA%E5%B1%8F2021-03-20%2015.53.59.png)
[力扣](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/solution/mian-shi-ti-63-gu-piao-de-zui-da-li-run-dong-tai-2/)

![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/%E6%88%AA%E5%B1%8F2021-03-20%2016.01.15.png)

## 解题思路（动态规划）
![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/501744E7-11FE-4CF4-A861-859CCFFF9A06.png)

之所以返回dp[n-1]，因为是从第0天开始的

![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/D8E6A983-42B4-4EB2-A253-FCBCE0590D9C.png)

效率优化：
![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/994E4C85-55F1-440C-88F4-F917252F5AEB.png)
1. 使用变量cost，记录最低价格
2. 使用变量profit记录收益最大值，这样就不需要创建dp数组
## 复杂度分析
![](Offer63.%20%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E5%A4%A7%E5%88%A9%E6%B6%A6/%E6%88%AA%E5%B1%8F2021-03-20%2016.13.31.png)


## 代码
```
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


```
```
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/solution/mian-shi-ti-63-gu-piao-de-zui-da-li-run-dong-tai-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```







