# 腾讯高频2：爬楼梯（Leetcode 70）
![](%E8%85%BE%E8%AE%AF%E9%AB%98%E9%A2%912%EF%BC%9A%E7%88%AC%E6%A5%BC%E6%A2%AF%EF%BC%88Leetcode%2070%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-15%2014.37.47.png)

[力扣](https://leetcode-cn.com/problems/climbing-stairs/)

## 题目描述
假设你正在爬楼梯。需要 *n* 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
**注意：**给定 *n* 是一个正整数。

## 解题思路
* 用f(x)表示爬到x级台阶的方案数量，由于最后一步，可能爬了1个台阶，也可能爬了两个台阶，所以：f(x) = f(x-1) + f(x-2)
![](%E8%85%BE%E8%AE%AF%E9%AB%98%E9%A2%912%EF%BC%9A%E7%88%AC%E6%A5%BC%E6%A2%AF%EF%BC%88Leetcode%2070%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-15%2014.47.24.png)

* 但是要注意有几种特殊情况，当n<=2时，dp(2) = dp(1)+dp(0)
	* 所以要先设置好 dp[0] =1 ; dp[1] = 1;
	* 并且要注意创建数组要创建 int[n+1]大小的数组
* 返回dp[n]即可

### 代码
```
class Solution {
    public int climbStairs(int n) {
        // fn = fn-1 + fn-2
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //题目给定n是正整数 n>0
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
```