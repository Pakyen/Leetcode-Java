import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-19 8:15 PM
 */
/*
集合S1：M个整数
集合S2：N个整数

S1中的元素互不相同
S2中的元素互不相同

给定整数K，从S1和S2里各取一个整数，使他们的和为K

问存在多少种不同的选取方案？不存在输出0
S1 S2    S1 S2
[A,B] 和 [B, A] 是两种不同的选取方案


 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] s1 = new int[m];
        int[] s2 = new int[n];

        for (int i = 0; i < m; i++) {
            s1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            s2[i] = in.nextInt();
        }
        System.out.println(choiceK(s1,s2,m,n,k));
    }
    private static int choiceK(int[] s1, int[] s2, int m, int n, int k){
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(s1[i]+s2[j]==k){
                    res++;
                }
            }
        }
        return res;
    }
}
