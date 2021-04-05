package Greedy;

/**
 * @author hbx
 * @date 2021-04-05 14:47
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums){
        // int res = 0;
        int res = nums[0];  //防止nums只有一个元素的情况
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(sum<=0){
                sum = nums[i];
            }else{
                sum+=nums[i];
            }
            res = res>sum? res:sum;
        }
        return res;
    }
}
