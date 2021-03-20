package Tencent;

class Tencent1 {
    public int maxSubArray(int[] nums) {
        int res=nums[0], sum=0;

        for(int x : nums){
            if(sum<=0){
                sum = x;
            }else{
                sum += x;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}