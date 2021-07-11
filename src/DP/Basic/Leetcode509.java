package DP.Basic;

/**
 * @author hbx
 * @date 2021-07-11 14:28
 * 斐波那契数
 */
class Leetcode509 {
    public static void main(String[] args) {

    }
    public int fib(int n) {
        if(n<=1)
            return n;
        return fib(n-1)+fib(n-2);
    }
}

