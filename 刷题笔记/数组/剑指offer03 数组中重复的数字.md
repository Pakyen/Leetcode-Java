# 剑指offer03 数组中重复的数字

这道题在原书上绝对不是简单级别啊！
::它考察的是程序员的沟通能力，先问面试官要时间/空间需求！！！::
::只是时间优先就用字典，::
::还有空间要求，就用指针+原地排序数组，::
::如果面试官要求空间O(1)并且不能修改原数组，还得写成二分法！！！::
# 最初解法
两层for循环嵌套，遇到相同的数字直接输出。
但是注意不能不设置break,会超时
![](%E5%89%91%E6%8C%87offer03%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-04%2020.56.57.png)
```
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int flag = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n  ; j++) {
                if(nums[i]==nums[j])
                {
                    result=nums[i];
                    flag = 1;
                }
            }
            if(flag==1) break;
        }
        return result;
    }
}

```
时间复杂度：
空间复杂度：

## 方法2: Leetcode官方

由于只需要找出数组中任意一个重复的数字，因此遍历数组，遇到重复的数字即返回。为了判断一个数字是否重复遇到，使用集合存储已经遇到的数字，如果遇到的一个数字已经在集合中，则当前的数字是重复数字。

* 初始化集合为空集合，重复的数字 repeat = -1
* 遍历数组中的每个元素：
	* 将该元素加入集合中，判断是否添加成功
	* 如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历

* 返回repeat
```
class Solution{
	public int findRepearNumber(int[] nums){
	Set<Integer> set = new HashSet<Integer>();
	for(int num : nums){
		if(!set.add(num)){
			repeat = num;
			break;
		}
	}
	}
}
```


### 复杂度分析

* 时间复杂度：O(n)
	* 遍历数组一遍
	* 使用哈希集合，添加元素的时间复杂度为O(1)
	* 所以总的时间复杂度为O(n)
* 空间复杂度：O(n)
	* 不重复的每个元素都可能存入集合，因此占用O(n)额外空间













