package Recursion;
/*
求 1+2+...+n ，要求
不能使用乘除法、for、while、if、else、switch、case等关键字
及条件判断语句（A?B:C）
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n){
        boolean x = n>1 && sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
