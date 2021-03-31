# Offer 64 求1+2+…+n（逻辑运算符短路效应）

## 题目描述
[力扣](https://leetcode-cn.com/problems/qiu-12n-lcof/)
![](Offer%2064%20%E6%B1%821+2+%E2%80%A6+n%EF%BC%88%E9%80%BB%E8%BE%91%E8%BF%90%E7%AE%97%E7%AC%A6%E7%9F%AD%E8%B7%AF%E6%95%88%E5%BA%94%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-20%2015.08.46.png)

## 解题思路（逻辑运算符的短路效应）
[力扣](https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/)
首先：平均计算、迭代，都不可取
* 平均计算❌：要用到乘除法
* 迭代❌：迭代循环必须要用到while或者for
* 递归：终止条件要用到if，所以也不行
* ::递归::：但是除了if和switch等判断语句，还可以用逻辑运算符来实现终止条件的判断

* ::逻辑运算符的短路效应::：
	* 逻辑运算符：与&&、或||、非!
	* 短路效应
		* `if(A&&B)`：如果A为false，则B的判断不会执行，直接认定A&&B为false
		* `if(A||B)`：如果A为true，则B的判断不会执行，直接认定A||B为true

* 本题需要实现 “n==1时终止递归”的需求，可通过短路效应实现

* ::注意事项::：
	1. 需要借助一个**布尔辅助变量**，来实现条件判断，否则报错
	2. 开启递归函数，要改写为 sumNums(n-1)**>0**，整体作为一个布尔量输出，否则报错
	3. **初始化变量**res记录结果


```
n>1 && sumNums(n-1)  
```
当n=1时，n>1就不成立，此时短路，终止递归

## 复杂度分析
![](Offer%2064%20%E6%B1%821+2+%E2%80%A6+n%EF%BC%88%E9%80%BB%E8%BE%91%E8%BF%90%E7%AE%97%E7%AC%A6%E7%9F%AD%E8%B7%AF%E6%95%88%E5%BA%94%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-20%2015.34.18.png)


## 代码
```
/*
求 1+2+...+n ，要求
不能使用乘除法、for、while、if、else、switch、case等关键字
及条件判断语句（A?B:C）
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n){
        boolean x = n>1 && sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
```