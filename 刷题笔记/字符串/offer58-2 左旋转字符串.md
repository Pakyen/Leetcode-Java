# offer58-2 左旋转字符串

![](offer58-2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2/%E6%88%AA%E5%B1%8F2021-02-16%2015.05.44.png)

## 方法一 切片

![](offer58-2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2/%E6%88%AA%E5%B1%8F2021-02-16%2015.12.49.png)
```
class Solution {
    public String reverseLeftWords(String s, int n) {
        if(n==0 || n==s.length()) return s;
        String tail = s.substring(0,n);
        return s.substring(n,s.length()).concat(tail);
    }
}
```
或
```
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
```

::若面试不允许使用切片函数:::
## StringBuilder+求余
::使用求余运算可以简化代码！！::
![](offer58-2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2/%E6%88%AA%E5%B1%8F2021-02-16%2015.15.00.png)
![](offer58-2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2/C71C751A-4069-47A9-BFE4-6DD3D9003C32.png)
![](offer58-2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2/C793668C-5C9B-44DD-BCA8-4976510EE56F.png)
```
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n+s.length(); i++) {
            res.append(s.charAt(i%s.length()));
        }
        return res.toString();
    }
}
```


