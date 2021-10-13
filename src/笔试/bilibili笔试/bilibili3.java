/**
 * @author hbx
 * @date 2021-10-13 7:39 PM
 */
/*
对发布动态做一个频率控制，规则如下：如果在过去T秒内发布的动态数目达到了N条，那么会立刻触发封禁：在接下来的t秒内，这个账号都不能发布动态。

请你帮阿斌实现这个频控算法（支持同时配置多个规则），并计算出黑客的某个发布序列中共有多少条动态被阻止发布。

输入输出规定：

假定黑客的发布序列是一个数组，形如：[1,0,1,0,1,0,1,0]，其中1代表发布了动态，0代表未发布动态。

每个规则也可以表示为一个数组，形如: [10, 2, 5]，表示过去10秒内发布动态达到2条，就会立刻触发5秒的封禁。

逻辑简化：

多个规则互相独立，互不干扰。规则不超过10个。

发布动态数达到阈值时，立刻触发封禁。

不在封禁状态下的每一秒钟，都需要根据发布历史重新计算是否会命中频控。（封禁状态下不需要重新计算）

提示：

  比如对于发布序列 [1,0,1,1] 和规则 [10,2,5]，第1秒和第3秒可以成功发布动态。然后第4秒就会触发封禁，封禁5秒，所以第4秒的动态发布会失败。因此，最终一共会有2条动态可以成功发布，1条动态被阻止。
 */
/*
ac33%
 */
public class bilibili3 {
    public static void main(String[] args) {
        String input = "[1,0,1,1]";
        int rule_cnt = 1;
        String rules = "[10,2,5]";
        System.out.println(check(input,rule_cnt,rules));
    }
    //返回被阻止发出的动态数量
    //序列，规则个数，规则数组
    public static int check(String input, int rule_cnt, String rules) {
        //处理输入
        String str = input.substring(1,input.length()-1);
        String[] valueArr = str.split(",");
        int[] arr = new int[valueArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(valueArr[i]);
        }
        int[][] rule = new int[rule_cnt][3];
        int left = 0, right = 0;
        int s = 0;
        for (int i = 0; i < rules.length(); i++) {
            if(rules.charAt(i)=='['){
                left = i;
            }
            if(rules.charAt(i)==']'){
                right = i;
                String str1 = rules.substring(left+1,right);
                String[] valueArr1 = str1.split(",");
                rule[s][0] = Integer.parseInt(valueArr1[0]);
                rule[s][1] = Integer.parseInt(valueArr1[1]);
                rule[s][2] = Integer.parseInt(valueArr1[2]);
                s++;
            }
        }
        //序列。arr[]
        //规则数量 rule_cnt
        //规则 rule[i][]
        int[] count = new int[rule_cnt];
        boolean block = false;
        int releaseBlock = 0;
        int failed = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1 && block){
                failed++;
            }
            if(arr[i]==1){
                for (int j = 0; j < rule_cnt; j++) {
                    count[j]++;
                }
            }
            for (int j = 0; j < rule_cnt; j++) {
                //如果某个时刻
                if(!block && i>count[j]){
                    if(arr[i-count[j]]==1) count[j]--;
                }
                //如果某个时间，到达block条件
                if(!block && count[j]>=rule[j][1]){
                    block=true;
                    int ifreleaseBlock = i+rule[j][2];
                    if(ifreleaseBlock>releaseBlock){
                        releaseBlock = ifreleaseBlock;
                    }
                }

            }

        }

        return failed;
    }
}
