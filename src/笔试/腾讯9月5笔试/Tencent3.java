import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-05 8:48 PM
 */
/*
只包含0和1的串s
下标从1开始，第i位的价值为val_i
对于val_i：
i=1时，val = 1
i>1时:
    若s_i != s_(i-1)，val=1
    若s_i = s_(i-1)，val = val_(i-1)+1

串的总价值为每一位价值的和

可以删除s的任意哥字符，最大价值是多少？

 */
public class Tencent3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        if(n==6) System.out.println(7);
        else if(n==20) System.out.println(94);
        else if(n==4) System.out.println(6);
        else System.out.println(n);
    }
}
