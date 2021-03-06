package Array.No27;
//双指针法
//让时间复杂度从O(n^2)降到O(n)

public class Solution{
    public int removeElement(int[] nums, int val){
        int i = 0; //慢指针
        for (int j = 0; j < nums.length; j++) {
            //如果nums[j]=val的话，j往前，i不往前
            if(nums[j]!=val){
                //如果nums[j]不等于val，
                //那么用j覆盖i位置的元素，并且i也往前一步
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
