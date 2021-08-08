package Huawei;



/**
 * @author hbx
 * @date 2021-08-05 5:27 PM
 */
import java.util.Scanner;
public class 笔试2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int time = 0;
        System.out.println(minTime(n,m,0));
    }
    public static int minTime(int n, int m, int time){
        //时间 = 当前花费时间+之前花费时间
        if(n==m){
            return time;
        }
        if(n<0) return 0;
        int t1 = time;
        int t2 = time;
        int t3 = time;
        int t4 = time;
        if(n<m){
            t1 = minTime(n+1,m,time)+1;
            if(n>1){
                t2 = minTime((n-1)*2,m,time)+2;
            }
            t3 = minTime(n*2,m,time)+1;
        }
        t4 = minTime(n-1,m,time)+1;
        return Math.min(Math.min(t1,t2),t3);
    }
}
