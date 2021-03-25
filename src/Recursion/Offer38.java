package Recursion;

import java.util.HashSet;
import java.util.LinkedList;

public class Offer38 {
    LinkedList<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {

    }
    void dfs(int x){
        if(x==c.length-1){
            //添加排列方案

        }
        //判断重复
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; //有重复就剪枝
            set.add(c[i]);
            swap(i,x);          //交换，将c[i]固定在x位
            dfs(x+1);
            swap(x,i);
        }

    }
    void swap(int a, int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
