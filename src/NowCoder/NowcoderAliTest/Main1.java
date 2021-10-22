package NowcoderAliTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-12 11:19 AM
 */
/*
https://www.nowcoder.com/questionTerminal/a55198d2e65746009110226f2f6c8533?f=discussion
 */
/*
ac100
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                arr[j][1] = in.nextInt();
            }
            System.out.println(maxItemNumber(arr));
        }
    }
    public static int maxItemNumber(int[][] arr) {

        int n = arr.length;
        //首先根据x 对arr进行排序；如果x相等，按y从大到小排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //如果不相等，按x升序
                //如果相等，按y降序
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o2[1]-o1[1];
            }
        });
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = arr[i][1];
        }
        //求最长递增不连续子序列 （不是单纯的从头开始找y递增）
        //len保存最长递增子序列的大小
        int len = 1;

        // dp[i] 长度为i的最长递增子序列的末尾元素（尽量小）
        int[] dp = new int[arr.length+1];
        dp[1] = y[0];
        //贪心思想：在子序列长度一样时，希望dp[i]尽可能小，也就是递增子序列的末尾元素尽可能小
        for (int i = 1; i < arr.length; i++) {
            if(y[i]>dp[len]){
                dp[++len] = y[i];
            }else{
                //使用二分法，找到dp中，最大的比y[i]还要小的数dp[k]
                int low = 1, high = len, pos = 0;
                while(low<=high){
                    int mid = low + (high-low)/2;
                    if(dp[mid]<y[i]){
                        //找到了比y[i]小的数dp[k]，不过可能不是最大的，先记录下来它的位置pos
                        pos = mid;
                        low = mid+1;
                    }else{
                        high = mid -1;
                    }
                }
                dp[pos+1] = y[i]; //换掉pos+1位置的，比y[i]大的数，保证了dp末尾最小
                /*
                哪怕pos+1是在dp[len]之前的位置，替换掉了dp数组前面的数据，也没关系。
                这样只是说明，当长度为dp[pos+1]的时候，末尾最小是y[i]，不会影响结果的len
                因为len之后在y[i]>dp[len]的时候，才会被更新
                 */
            }
        }

        return len;
    }
}
