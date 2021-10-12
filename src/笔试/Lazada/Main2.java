import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-13 12:36 AM
 */
/*

 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[][] arr = new int[m][2];
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            if(arr[i][1]>max) max = arr[i][1];
        }
        int[] sum = new int[max+1];
        int[] vis = new int[max+1];
        for (int i = 0; i < max+1; i++) {
            sum[i] = 0;
            vis[i] = 0;
        }
        for (int i=2; i<max+1; i++){
            sum[i] = sum[i-1];
            if(vis[i]==0) sum[i]++;
            for (int j = i*2; j <=max ; j+=i) {
                vis[j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int l = arr[i][0];
            int r = arr[i][1];
            System.out.println(sum[r]-sum[l]);
        }
        for (int i = 0; i < max; i++) {
            System.out.println(sum[i]);
        }
    }
}
