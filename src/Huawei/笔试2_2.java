package Huawei;



/**
 * @author hbx
 * @date 2021-08-05 5:43 PM
 */
//不能直接递归 要广度优先
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 笔试2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = minTime(n,m)-1;
        System.out.println(count);
    }
    public static int minTime(int n, int m){
        int[] visited = new int[100000];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n]=1;

        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp==m){
                return visited[m];
            }
            if(tmp+1<=m && visited[tmp+1]==0){
                q.offer(tmp+1);
                visited[tmp+1]=visited[tmp]+1;
            }
            if(tmp-1>=0 && tmp-1<=m && visited[tmp-1]==0){
                q.offer(tmp-1);
                visited[tmp-1] = visited[tmp] + 1;
            }
            if(tmp*2<=m && visited[tmp*2]==0){
                q.offer(tmp*2);
                visited[tmp*2] = visited[tmp]+1;
            }
        }
        return 0;
    }
}
