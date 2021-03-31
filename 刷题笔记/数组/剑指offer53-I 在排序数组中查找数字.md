# 剑指offer53-I 在排序数组中查找数字

![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-09%2016.45.26.png)
### 原来的解法
for循环，直到大于target就break
```
public class Solution {
    public int search(int[] nums, int target){
        int l = nums.length;
        int count = 0;
        for (int i = 0; i < l ; i++) {
            if(nums[i] == target){
                count++;
            }
            if(nums[i] > target){
                break;
            }
        }
        return count;
    }
}
```

时间复杂度：O(n)
空间复杂度：O(1)

### 二分法
参考：[力扣](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/)
> 排序数组的搜索问题，首先就要想到二分法  
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2012.40.57.png)
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/C8593EFA-9188-4BCA-8107-A1733D9B099E.png)
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2012.48.04.png)
思路：先用二分法查找右边界，再用二分法查找左边界
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2012.52.55.png)
最后开始查找边界的时候，如果有target，那么mid肯定是=target的。那么查找右边界的时候 i = mid + 1，
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2012.57.56.png)
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2012.58.16.png)
直到i = j，找到右边界，mid>target，这时候目标在 [i, m-1] 中，执行j=m-1，这时i>j跳出循环，i的值正好就是右边界，nums[j]正好是最右侧的target（如果存在），记录right=i。

1. 查找完右边界，就可以用nums[j]=target判断数组中是否包含target，若不包含就返回0，且不需要查找左边界
2. 查找完右边界后，左边界left一定在区间[0,j]中，继续二分查找左边界即可。
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/%E6%88%AA%E5%B1%8F2021-02-10%2013.02.45.png)
### 代码：
> 可以将nums[m]=target的情况合并到其他两种情况中  
- - - -
改进：
![](%E5%89%91%E6%8C%87offer53-I%20%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E6%95%B0%E5%AD%97/60D7D4D3-9027-41FE-AEAC-57EAB171222E.png)
> 由于数组中的元素都是整数，所以其实可以查找target的右边界，和target-1的右边界，然后两个结果相减就是结果  
>   
> 如果target不在数组中，两个右边界相等，返回0  
```
public class Solution {
    public int search(int[] nums, int target){
        return helper(nums,target) - helper(nums,target-1);
    }
    public int helper(int[] nums, int tar){
        int i=0, j=nums.length-1;
        //寻找右边界
        while(i<=j){
            int m = (i+j)/2;
            //如果mid <= tar，右边界在[m+1,j]中
            if(nums[m] <= tar) i=m+1;
            //如果mid > tar，右边界在[i,m-1]中
            else j=m-1;
        }//当i>j时，i=右边界
        return i;
    }
```