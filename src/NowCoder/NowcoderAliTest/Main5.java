package NowcoderAliTest;

import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-10-19 10:02 AM
 */
public class Main5 {
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
    }
    private static double maximizeWorse(int[][] arr, int n){


    }
}
