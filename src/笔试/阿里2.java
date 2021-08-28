import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-27 7:42 PM
 */
/*
总耗时为到达集结点最慢的部队的时间
其实就是要避开沼泽，让最远距离最短
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int k = in.nextInt();
        //position
        //x = [k][0]
        int[][] p = new int[k][2];
        int max = 0;
        for (int i = 0; i < k; i++) {
            p[k][0] = in.nextInt();
            p[k][1] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int h = dfs(p[i][0],p[i][1],n/2,m/2,a,n,m,0);
            if(h>max) max = h;
        }
        System.out.println(max);
    }
    public static int dfs(int x, int y, int x0, int y0,int[][] a,int n, int m, int res){
        if(x==x0&&y==y0) return res;
        int[][] arr = Arrays.copyOf(a,a.length);
        if(x+1<n && arr[x+1][y]==0){
            x=x+1;
            arr[x][y] = 1;
            return dfs(x,y,x0,y0,arr,n,m,res)+1;
        }
        if(x-1>0 && arr[x-1][y]==0){
            x-=1;
            arr[x][y] =1;
            return dfs(x,y,x0,y0,arr,n,m,res)+1;
        }
        if(y+1<m&&arr[x][y+1]==0){
            y+=1;
            arr[x][y] = 1;
            return dfs(x,y,x0,y0,arr,n,m,res)+1;
        }
        if(y-1>0&&arr[x][y-1]==0){
            y-=1;
            arr[x][y] = 1;
            return dfs(x,y,x0,y0,arr,n,m,res)+1;
        }
        return 0;
    }
}

