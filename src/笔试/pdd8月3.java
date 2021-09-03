import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-31 7:35 PM
 */
/*
n条长度为1的木棍，
木棍能组成若干个1*1的正方形
想知道能组成多少个这样的正方形
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(fun(arr[i]));
        }
    }
    public static int fun(int n){

    }
}
