# offer67 把字符串转换成整数
[力扣](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)
![](offer67%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/%E6%88%AA%E5%B1%8F2021-02-14%2013.40.56.png)
![](offer67%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/%E6%88%AA%E5%B1%8F2021-02-14%2013.41.08.png)
根据题意，有以下四种字符or情况需要考虑：
	1. 首部空格：删除即可
	2. 符号：+，-，无符号
	3. 非数字：遇到首个非数字字符时，应该立即返回
	4. 数字：
		1. 字符转数字：“此数字的 ASCII 码” 与 “0 的 ASCII 码” 相减即可；
		2. 数字拼接：从左到右遍历数字，结果为：
			* ::res = res × 10 + x:: 【这样就不用判断位数】
			* x = ascii(c) - ascii(‘0’)
	5. 数字越界问题

![](offer67%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/1A478883-D7D5-437A-B4E0-82F7A274801B.png)
![](offer67%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/%E6%88%AA%E5%B1%8F2021-02-16%2015.44.17.png)
![](offer67%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/%E6%88%AA%E5%B1%8F2021-02-16%2015.47.05.png)
### 重点 注意事项
	* INT_MIN为：-2147483648
	* INT_MAX为：2147483647

	* 为什么要将boundary//10后再看最后一位x，而不是直接判断res和2147483647的大小呢？
		1. ::当res超过界限时，INT已经装不下res了，程序会报错，所以不能直接判断res和bndary的大小！！::⚠️

	* 负数的界限末尾为8，正数的界限末尾为7，为什么只用判断一个x？
		1. ::c[j] > ‘7’ 这里处理很巧妙，判断 > ‘7’ , 看似没有考虑 MIN, 但其实无论是 = ‘8’ ,还是 >’8’,返回的都是MIN::
		2. 而且这里不能判断c[j]>=7，因为当res=2147483647时，还没有到达MIN的界限，所以要c[j]>7
### 代码
```
class Solution {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length==0) return 0;
        int res = 0;
        int boundary = Integer.MAX_VALUE/10;
        //i表示位数，如果有符号，数字应该从第1位开始看起而不是第0位
        int i=1,sign=1;
        if(c[0]=='-') sign=-1;
        else if(c[0]!='+') i=0;
        for (int j = i; j < c.length; j++) {
            if(c[j]<'0' || c[j]>'9') break;
            if(res>boundary || res==boundary&&c[j]>'7')
                return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + (c[j]-'0');
        }
        return sign*res;
    }
}
```