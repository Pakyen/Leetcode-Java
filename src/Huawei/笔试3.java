package Huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-05 6:17 PM
 */


/*
1. 从跟节点开始，判断有没有相同的节点
2. 如果有相同的节点，判断是否存在子数
3. 将子树保存在二维List中
4. 输出最长的数组
 */


public class 笔试3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toString();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)-'0'>=0 && str.charAt(i)-'9'<=0){
                arr.add(str.charAt(i)-'0');
            }else if(str.charAt(i)=='n'){
                arr.add(-1);
                i += 5;
            }
        }
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size()-1; j++) {
                if(a[i]==a[j]){
                    int l1 = (i+1)*2-1;
                    int r1 = (i+1)*2;
                    int l2 = (j+1)*2-1;
                    int r2 = (j+1)*2-1;
                    if(l1==l2&&r1==r2){
                        String s = '[' + Integer.toString(a[i]) + ',' + Integer.toString(a[l1])+','+Integer.toString(a[r1])+']';
                        System.out.println(s);
                        return;
                    }else if(l1==l2){
                        String s = '[' + Integer.toString(a[i]) + ',' + Integer.toString(a[l1])+ ',' + "null" + ']';
                        System.out.println(s);
                        return;
                    }else if(r1==r2){
                        String s = '[' + Integer.toString(a[i]) + ',' + "null"+ ',' + Integer.toString(a[r1]) + ']';
                        System.out.println(s);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }


}