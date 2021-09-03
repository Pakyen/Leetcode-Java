import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-27 7:05 PM
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] red = new int[n];
        int[] blue = new int[m];
        for (int i = 0; i < n; i++) {
            red[i]=in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            blue[i] = in.nextInt();
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(n<=m){
            boolean[] used = new boolean[m];
        }else{
            boolean[] used = new boolean[n];
        }

    }
    //默认n<=m
    public static int backTracking(int startIndex, int n, int m){

        for (int i = 0; i < n ; i++) {

        }
    }
}
