# offer38 字符串的排列(回溯，剪枝）

# 题目描述
![](offer38%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97(%E5%9B%9E%E6%BA%AF%EF%BC%8C%E5%89%AA%E6%9E%9D%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-07%2013.30.27.png)

## 解题思路
![](offer38%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97(%E5%9B%9E%E6%BA%AF%EF%BC%8C%E5%89%AA%E6%9E%9D%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-07%2013.30.01.png)

### 元素有重复时，排列方案也有重复！！
::当字符串存在重复字符时，排列方案中也存在重复的排列方案::。为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，即遇到重复字符时不交换，直接跳过。从 DFS 角度看，此操作称为 ::“剪枝”:: 。
![](offer38%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97(%E5%9B%9E%E6%BA%AF%EF%BC%8C%E5%89%AA%E6%9E%9D%EF%BC%89/4C58D7A9-8EFD-49CA-B7E4-E70000DE9CEE.png)

### 递归解析

#### 终止条件
当x = len(c) -1时，代表所有位已固定（最后一位只有一种情况），则将当前组合c转化为字符串并加入res，并返回

#### 递推参数
当前固定位`x`

#### 递推工作
初始化一个Set，用于排除重复的字符；
将第x位字符与 i ∈ [x, len(c)] 分别交换，并进入下层递归；

	1. 剪枝：若c[i]在Set中，代表是重复的字符，因此 剪枝
	2. 将c[i]加入Set，以便之后遇到重复字符时剪枝
	3. 固定字符：将c[i]与c[x]交换，即固定c[i]为当前位字符
	4. 开启下层递归：调用dfs(x+1)，即开始固定第x+1个字符
	5. 还原交换：将字符c[i]和c[x]交换（还原之前的交换）

>   ![](offer38%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97(%E5%9B%9E%E6%BA%AF%EF%BC%8C%E5%89%AA%E6%9E%9D%EF%BC%89/%E6%88%AA%E5%B1%8F2021-03-07%2013.55.54.png)  


```
class Solution {
    char[] c;
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    private void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c)); //将排列方案加到list中
            return;
        }
        HashSet<Character> set = new HashSet<>();
        //从x位开始，依次交换x和i位置的元素，直到达到叶子结点
        for(int i=x; i<c.length;i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);      //交换，固定c[i]在x位
            dfs(x+1);       //开始固定x+1位字符
            swap(i,x);      //恢复交换
        }
    }

    private void swap(int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
```