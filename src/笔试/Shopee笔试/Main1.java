/**
 * @author hbx
 * @date 2021-10-25 3:35 PM
 */
/*
n条线段，长度从l1-ln
从中取出3条，组成一个三角形，求一共有多少种不同的组合
 */
/*
20分，ac 40%
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(Solve(4,new int[]{1,1,1,1}));
    }
    private static long Solve(int n, int[] lens) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
//                   int min = Math.min(Math.min(lens[i],lens[j]),lens[k]);
//                   int max = Math.max(Math.max(lens[i],lens[j]),lens[k]);
                   boolean b1 = lens[i]+lens[j]>lens[k];
                   boolean b2 = lens[i]+lens[k]>lens[j];
                   boolean b3 = lens[j]+lens[k]>lens[i];
                   if(b1&&b2&&b3) res++;
                }
            }
        }
        return res;
    }
}
