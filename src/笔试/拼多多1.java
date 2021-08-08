package 笔试;

import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-08 7:02 PM
 */
/*
坐标系中，给定圆心坐标xi,yi和半径ri，求每个圆与坐标轴的交点数量有多少个
ac100%
 */
public class 拼多多1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt(); //a
            arr[i][1] = in.nextInt(); //b
            arr[i][2] = in.nextInt(); //r
        }
        //y轴, x=0
        //(r^2-a^2)^1/2
        for (int i = 0; i < n; i++) {
            int result = 0;
            double det1 = Math.pow(arr[i][2],2) - Math.pow(arr[i][0],2);
            if(det1>0){
                result+=2;
            }
            if(det1==0){
                result+=1;
            }
            double det2 = Math.pow(arr[i][2],2) - Math.pow(arr[i][1],2);
            if(det2>0){
                result+=2;
            }
            if(det2==0){
                result+=1;
            }
            if(Math.pow(arr[i][0],2)+Math.pow(arr[i][1],2)==Math.pow(arr[i][2],2)){
                result -=1;
            }
            System.out.println(result);
        }
    }
}
