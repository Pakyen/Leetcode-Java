package NewCoder;

/**
 * @author hbx
 * @date 2021-08-05 1:24 PM
 */
import java.util.*;
/*
 * ⚠️ 回文串的长度也可能是偶数（如 aabb)
 * 一个元素可以作为中心点，两个元素也可以作为中心点
 */
public class NC17 {
    public int getLongestPalindrome(String A, int n) {
        //边界判断
        if(n<2)
            return A.length();

        int maxLen = 1;

        for (int i = 0; i < n-1; i++) {
            // 比较以i为中心扩散的回文子串 && 以i和i+1为中心扩散的回文子串
            int len1 = centerSpread(A,i,i);
            int len2 = centerSpread(A,i,i+1);
            int len = len1>len2 ? len1:len2;
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
    //若left==right 则扩散中点为一个，此时的回文子串为奇数
    //若left!=right，则扩散的中点为 left和right，此时的回文子串为偶数
    public int centerSpread(String s, int left, int right){
        int len = s.length();
        int l = left;
        int r = right;
        while(l>=0 && r<=len-1){
            //若相等就继续扩散
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }else
                break;
        }
        //为什么还要减2  因为上面while循环终止了，此时s.charAt(l) != s.charAt(r)
        //所以此时的回文子串的左右边界其实是  l-1，  r-1
        return r-l+1-2;
    }
}


