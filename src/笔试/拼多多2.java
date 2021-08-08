package 笔试;

import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-08 7:29 PM
 */
/*
left = 0
right = left + c -1
从头到尾遍历区间，看有多少个区间，里面的甜度都不超过t，如果区间内有糖的甜度超过t，这个区间就不能选

 ac30% 运行超时
 修改后ac100%
 */
public class 拼多多2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int c = in.nextInt();
        int[] sweet = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            sweet[i] = in.nextInt();
            if(sweet[i]>t) k = i;
        }

        int left = 0;
        int right = left + c -1;
        int count = 0;

        while(right<n && left<n){
            boolean flag = true;
            for (int i = left; i <= right && i<n ; i++) {
                if(sweet[i]>t){
                    flag = false;
                    left = i;
                    right = left + c -1;
                    break;
                }
            }
            if(flag==true){
                count+=1;
            }
            left++;
            right++;
            if(left>k){
                break;
            }
        }
        if(n-left-c+1>0){
            count+=n-left-c+1;
        }
        System.out.println(count);
    }
}
