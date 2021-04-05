package Greedy;

import java.util.Arrays;

/**
 * @author hbx
 * @date 2021-04-05 10:28
 */
public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        //一种最简单的方式就是先从胃口最小的孩子开始，拿最小的饼干试一下能不能满足他，如果能满足就更好，如果不能满足，在找稍微大一点的，如果还不能满足就再找更大一点的……
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int count =0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]) {
                count+=1;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
