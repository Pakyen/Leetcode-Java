/**
 * @author hbx
 * @date 2021-10-15 7:44 PM
 */
/*
    n个城市：0~n-1：
    双向路径：[xi,yi,time_i]
        可能会存在多条路连接两个city
    每次经过一个city，要给passing fee[i]
    起始位置位于city0，想去city(n-1)，花费时间<= maxTime，华为金钱cost
    cost：passing fees的和（包含起始位置）

    求最小费用
 */
/*
    输入：
    最大时间, 二维数组，一维数组
 */
/*
ac 71.43%
 */
public class Flower1 {
    public static void main(String[] args) {

    }
    public static int minCostWithTimeLimited (int maxTime, int[][] edges, int[] passingFees) {
        int minTime = Integer.MAX_VALUE;

        //当前城市
        int cur = 0;
        //遍历每条路，第i条路
        int time = 0;
        int cost = passingFees[0];
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0]==cur){
                //下一个城市
                cur = edges[i][1];
                cost += passingFees[cur];
                time += edges[i][2];
                if(time>maxTime) return -1;
                if(cur==passingFees.length){
                    break;
                }
            }
            if(i>0 && edges[i][0]==0){
                time = edges[i][2];
                cur = edges[i][1];
                cost = passingFees[0] + passingFees[cur];
                if(time>maxTime) return -1;
                if(cur==passingFees.length){
                    break;
                }
            }
        }
        return cost;
    }
}
