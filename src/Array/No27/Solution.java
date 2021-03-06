package Array.No27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int mark = 0; //最终长度
        for (int i = 0; i < len; i++) {
            if (nums[i]==val){
                mark += 1;
            }
        }
        for (int i = 0; i <len ; i++) {
            if(nums[i]==val){
                for (int j = len-1; j > i; j--) {
                    if(nums[j]!=val){
                        nums[i] = nums[j];
                        nums[j] = val;
                        break;
                    }
                }
            }
        }
        return len - mark;
    }
}