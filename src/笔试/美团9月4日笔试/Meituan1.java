import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-27 7:05 PM
 */
/*
多少个长为n的字符串，仅由a和b组成，不包含aba，也不包含bab？
答案要模上998244353
 */
/*
ac18,为什么
 */
public class Meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = fun(n)%998244353;
        System.out.println(res);
    }
    public static int fun(int n){
        if(n<3){
            return 2*n;
        }else{
            return (fun(n-1)*2-2)%998244353;
        }
    }
}
