import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-04 5:39 PM
 */
/*
小美和小团上课时学到了切尾平均的概念：是指在一个数列中，去掉两端的极端值后所计算的算术平均数。

现在他们思考这样一个问题：在一个n个数构成的序列中，怎么快速找出切尾平均最大的一个长度为m的连续子区间。在这个问题的切尾平均中，仅去除最大值和最小值。小美和小团想了很久，发现不会做，于是向你求助。



输入描述
第一行两个正数n和m，含义如上文。

第二行n个非负整数，a1,...,an，表示给出的序列。

3≤m≤n≤105,0≤ai≤109。

输出描述
输出一个正整数，表示切尾平均最大的区间的左端点，若有多个答案输出最小的一个。


样例输入
5 3
3 2 3 1 1
样例输出
1

提示
输入样例2

10 3

14 24 14 22 44 29 33 45 36 48

输出样例2

8
 */
/*
ac 64%
 */
public class Meituan5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(cut(arr,n,m));
    }
    public static int cut(int[] arr, int n, int m){
        //对于所有那么多组，记录最大值，和最大值对应的坐标!!
        int maxCut = 0;
        int flag = 0;
        for (int i = 0; i <= n-m; i++) {
            //j是偏移量，从i到i+m
            //对于每一组i，记录一个最小值，总值，均值
            int sum =0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < m+i; j++) {
                sum += arr[j];
                if(arr[j]<min) min = arr[j];
                if(arr[j]>max) max = arr[j];
            }
            int cut = (sum-max-min)/(m-2);
            if(cut>maxCut){
                maxCut = cut;
                flag = i;
            }
        }
        return flag+1;
    }
}
