package Array.No35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1; //定义target在左闭合右闭合的区间里[left,right]
        while(left <= right){
            int middle = left + ((right-left)/2); //防止溢出 等同于(left+right)/2
            if(nums[middle]>target){
                right = middle -1; //target在左区间，所以[left, middle-1]
            } else if (nums[middle]<target){
                left = middle+1; //target在右区间，所以[middle+1, right]
            } else{
                //nums[middle]==target
                return middle;
            }
        }
        //上面是target在数组中的情况
        // 2 target在所有目标之前
            //那么上面的循环最后middle最后会变成0，而且nums[0]还大于target
            //最后left是0不变，right = middle-1 = -1    -> [0,-1]
            //应该插入的位置是0，所以返回right+1
        // 3 target在所有目标之后
            //left会一直+1，直到大于right为止 [left, right]
            //right一直不变，就是n-1，所以返回right+1
        // 4 target在数组内部插入，但不等于数组内元素
            //最终结束的时候，如果target小于middle，left+1后大于right，那么就是[right,left]
            //返回right+1即可
            //如果target大于middle，right-1后小于left，[right,left]，那么也是返回right+1
        return right+1;
    }
}