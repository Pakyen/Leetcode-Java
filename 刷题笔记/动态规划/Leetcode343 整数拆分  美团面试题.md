# Leetcode343 整数拆分 / 美团面试题

## 题目描述
给定一个正整数 *n*，将其拆分为**至少**两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
[力扣](https://leetcode-cn.com/problems/integer-break/)

![](Leetcode343%20%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86%20%20%E7%BE%8E%E5%9B%A2%E9%9D%A2%E8%AF%95%E9%A2%98/%E6%88%AA%E5%B1%8F2021-03-22%2014.56.33.png)

一个正整数n，可以拆分成为2~n个正整数。

## 方法1：动态规划
* 对于n来说，当n>=2时，可以拆分成至少两个正整数的和。设x是拆分出来的第一个正整数，那么剩下的部分就是n-x
* n-x可以不拆分，也可以继续拆分成至少两个正整数的和
* ::由于每个正整数对应的最大乘积 取决于比它小的正整数的最大乘积，像是分支一样，所以可以用动态规划来解::

* dp[i] 表示将正整数i拆分成至少两个正整数的和之后，这些正整数的最大乘积
* 其中，0不是正整数，1是最小的正整数，0和1都不能拆分，所以dp[0] = dp[1] = 0

* 当i>=2时，假设正整数i拆分出来的第一个正整数时j，则有两种解决方案
	* 将i拆分成 j 和（i-j ），且(i-j)不再继续拆分，此时乘积是 j × (i-j)
	* 将i拆分成 j 和（i-j），但是(i-j)继续拆分，此时乘积 j ×dp[i-j]

### 复杂度分析
![](Leetcode343%20%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86%20%20%E7%BE%8E%E5%9B%A2%E9%9D%A2%E8%AF%95%E9%A2%98/%E6%88%AA%E5%B1%8F2021-03-22%2015.21.54.png)
### 代码
```
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
}
```


## 方法2：数学
[力扣](https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/)
	1. 当所有拆分出的数字相等时，乘积最大
	2. 将数字*n* 尽可能以因子3 等分时，乘积最大

### 算法流程
	1. 当n<=3时，应该不拆分，但是题目要求至少拆分成2个整数。所以就拆分成1 * (n-1)即可，最大值为n-1
	2. 当n>=3时，将n拆分成很多个值为3的因子。求n除以3的整数部分a，和余数部分b（即n=3a+b）
		* 当b=0时，直接返回3^a
		* 当b=1时，要把一个3+1转化为2+2，所以返回3^(a-1) × 4
		* 当b=2时，返回3^a × 2
### 复杂度分析
![](Leetcode343%20%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86%20%20%E7%BE%8E%E5%9B%A2%E9%9D%A2%E8%AF%95%E9%A2%98/%E6%88%AA%E5%B1%8F2021-03-22%2015.32.40.png)

### 代码
```
public int integerBreak2(int n){
    if(n<=3) return n-1;
    int a = n/3, b = n%3;
    if(b==0) return (int)Math.pow(3,a);
    if(b==1) return (int)Math.pow(3,a-1) * 4;
    return (int)Math.pow(3,a) * 2;
}
```

