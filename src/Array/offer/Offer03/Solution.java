package Array.offer.Offer03;

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