import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-05 8:25 PM
 */

/*
问题化简：
对于每一个精灵，要求出它的因子数，表示攻击力大小！


小B出战顺序就是1-n
小A可以改变顺序，求最多可以赢多少回合！

 */
/*
ac 40%，超时
 */
public class Tencent2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            a[i] = factorNum(a[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            b[i] = factorNum(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(battle(a,b,n));
    }
    /*
    对于一个数k，求有多少个因子
     */
    public static int factorNum(int k){
        int sum = 1;
        for (int i = 2; i*i <= k; i++) {
            if(k%i==0){
                int tmp = 0;
                while(k%i==0){
                    k/=i;
                    tmp++;
                }
                sum = sum*(tmp+1);
            }
        }
        if(k>1) sum=sum*2;
        return sum;
    }
    /*
    两个序列，求A最多赢B多少回合
    int A为因子数量序列

    A B 均为生序

    且a[i] b[i]均>=1
    所以A[i] B[i]均>=1
     */
    public static int battle(int[] A, int[] B, int n){
        if(A[n-1]<=B[0]) return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(B[j]!=-1){
                    if(A[i]>B[j]){
                        res+=1;
                        B[j]=-1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
