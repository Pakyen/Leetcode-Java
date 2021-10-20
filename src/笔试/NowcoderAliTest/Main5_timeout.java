package NowcoderAliTest;

import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-19 9:51 AM
 */
public class Main5_timeout {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.parseInt(str);
        int[][] ability = new int[n][2];
        for (int i = 0; i < n; i++) {
            str = in.nextLine();
            ability[i][0] = Integer.parseInt(str.split(" ")[0]);
            ability[i][1] = Integer.parseInt(str.split(" ")[1]);
        }
        System.out.println(maximizeWorse(ability, n));
    }
    public static double maximizeWorse(int[][] arr, int n){
        double res = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double X = (arr[i][1] + arr[j][1])/2.0;
                double Y = (arr[i][0] + arr[j][0])/2.0;
                double small = Math.min(X,Y);
                res = small>res? small:res;
            }
        }
        return res;
    }
}
