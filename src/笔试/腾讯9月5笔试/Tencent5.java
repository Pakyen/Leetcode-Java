import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-05 9:24 PM
 */
/*
有效序列定义：
    两端的数一个是最小值，一个是次小值【也就是中间的数肯定都大于等于两端的数】

给定一个序列a，求出序列中有多少个有效序列

ps:
    子序列指的是连续子序列
    长度为2的子序列，一定是有效序列
    长度为1的子序列，一定不是有效序列

输入
n
a[i]


ac 40%
超时

 */
public class Tencent5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(validSubArray(a));
    }
    /*
    双指针，表示滑动窗口
    窗口大小从2到L，以窗口大小进行循环
    滑动过程中，维护窗口的 最小值和次小值
        -> 怎么维护？
            维护一个优先队列

     */
    public static int validSubArray(int[] a){
        if(a.length<2) return 0;
        if(a.length==2) return 1;

        //窗口大小为3开始
        int res = a.length-1;
        for (int windowsSize = 2; windowsSize < a.length; windowsSize++) {
            int i = 0;
            int j = i+windowsSize;
            //窗口滑动
            for(;j<a.length;i++,j=i+windowsSize){
                int head = a[i];
                int tail = a[j];
                boolean valid = true;
                for (int k = i+1; k <j ; k++) {
                    if(a[k]<head || a[k]<tail){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    res++;
                }
            }
        }
        return res;
    }
}
