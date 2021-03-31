# offer58-I 翻转单词顺序
参考：[力扣](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/)
![](offer58-I%20%E7%BF%BB%E8%BD%AC%E5%8D%95%E8%AF%8D%E9%A1%BA%E5%BA%8F/%E6%88%AA%E5%B1%8F2021-02-14%2013.15.38.png)

## 方法 双指针
![](offer58-I%20%E7%BF%BB%E8%BD%AC%E5%8D%95%E8%AF%8D%E9%A1%BA%E5%BA%8F/%E6%88%AA%E5%B1%8F2021-02-14%2013.20.14.png)
### 算法流程
1. 删除首尾空格
2. 循环执行
	1. 索引i从右向左搜索首个空格
	2. 搜索到空格时，添加单词s[i+1:j+1]至res
	3. 索引i跳过单词间的所有空格
	4. 执行j=i，此时j指向下个单词的尾字符

```
public class Solution {
    public String reverseWords(String s){
        //该方法返回一个去除首尾空格的copy
        s = s.trim();
        int j =s.length()-1;
        int i=j;
        StringBuilder res = new StringBuilder();
        while(i>=0){
            //1.搜索首个空格
            while(i>=0 && s.charAt(i)!=' ')
                i--;
            res.append(s.substring(i+1,j+1) + ' ');
            //ps: substring左闭右开

            //2.跳过单词间的空格
            while(i>=0 && s.charAt(i)==' ')
                i--;
            //j指向下个单词的尾字符
            j=i;
        }
        return res.toString().trim();//转化为字符串并返回
    }
}
```