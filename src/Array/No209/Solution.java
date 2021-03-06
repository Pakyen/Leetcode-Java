package Array.No209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //数组长度
        int n = nums.length;
        //边界情况，如果数组长度为0
        if (n==0) {return 0;}
        //最小长度
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;

        while(end<n){
            sum += nums[end];
            while(sum >= s){
                ans = Math.min(ans, end-start+1);
                // sum超过s了，可以将start右移再进行判断
                sum -= nums[start];
                start++;
            }
            end++; //如果窗口和不超过s，end右移
        }
        return ans == Integer.MAX_VALUE ? 0:ans;
    }
}