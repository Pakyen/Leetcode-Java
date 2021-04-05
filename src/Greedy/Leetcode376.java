package Greedy;

/**
 * @author hbx
 * @date 2021-04-05 14:21
 */
/*
要得到最长摆动序列，不需要思考的太复杂。
只需要删除单调坡上的结点（除了两端）即可

如何判断摆动：前一个差值，和后一个差值，一个为正数，一个为负数，就=一个峰值（注意不能相乘，峰值可能为0）

最长摆动序列的长度，其实
 */
public class Leetcode376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1) return nums.length;

        int curDiff = 0;  //当前差值
        int preDiff = 0;  //上一个差值
        int res = 1;      //记录峰值个数，默认序列最右边有一个峰值

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];

            if((curDiff>=0 && preDiff<=0) || (curDiff<0 && preDiff>=0)){
                res++;
                preDiff=curDiff;
            }
        }
        return res;
    }
}
