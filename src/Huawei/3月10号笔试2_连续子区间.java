/*
华为2 挑选货物

N个箱子，从1开始编号
每个箱子的货物数量 M = {M1, M2, ..., Mn}

货车一次最多运送K件货物，小王想运输K的整数倍货物，再分批运输

但管理员要求小王只能选择编号连续的包装箱（如1，2，3）

请问小王有多少种挑选方式

输入：
N K
M1 M2 M3 M4
输出：
挑选方式的数量，如果不存在输出0

实际上是问，数组的连续子区间，子区间的合是k的倍数，有多少个这样的子区间

Ac 70%，部分超时
换Hashmap做之后不超时，但是ac40%
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res =0;
        int[] arr = new int[n];
        long[] sum = new long[n+1]; //代表[1:n]的子区间合
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum[i+1] = sum[i] + arr[i];
        }
        for (int i = 0; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                long sub = sum[j] - sum[i];
                if(sub==k ||(k!=0 && sub%k==0 )){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
