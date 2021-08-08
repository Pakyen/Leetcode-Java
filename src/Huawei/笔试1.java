package Huawei;

/**
 * @author hbx
 * @date 2021-08-05 4:47 PM
 */
/*
 ** 体积 = 底面积*高

 其实就是求联通区域内高度数值相加最大的联通区域
 所以其实就是要用dfs，找出所有联通区域，再判断每个联通区域的和的大小
*/
import java.util.Scanner;
public class 笔试1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int l = in.nextInt();
        int[][] arr = new int[w][l];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int maxValue = 0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l; j++) {
                if(arr[i][j]>0){
                    maxValue = Math.max(maxValue,dfs(arr,i,j));
                }
            }
        }
        System.out.println(maxValue);
    }

    //对于一个节点x,y：要判断它的上下左右
    public static int dfs(int[][] nums, int x, int y){
        if(x<0||x>=nums.length||y<0||y>=nums[x].length||nums[x][y]==0){
            return 0;
        }
        int sum = nums[x][y];
        nums[x][y] = 0;
        sum+= dfs(nums,x+1,y); //右
        sum+= dfs(nums,x-1,y); //左
        sum+= dfs(nums,x,y+1); //下
        sum+= dfs(nums,x,y-1); //上

        return sum;
    }
}
