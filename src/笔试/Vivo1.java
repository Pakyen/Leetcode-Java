/**
 * @author hbx
 * @date 2021-09-22 3:01 PM
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 计算满足条件：”确保avg_cost <= K，同时能给平台吸引到最多的新用户“ 的用户集合。
 返回列表格式，按用户id升序排序
// * @param userIdList int整型一维数组 用户id列表
// * @param costList double浮点型一维数组 用户的成本列表，和用户id列表一一对应
// * @param conversionList double浮点型一维数组 用户转化概率列表，和用户id列表一一对应
// * @param avg_cost double浮点型 约束的最高期望推广成本
// * @return int整型一维数组
 */
/*
给用户person_i发消息需要费用cost_i，该用户有p_i概率被吸引
期望推广成本 avg_cost = 总费用 / 总期望转化用户数

确保avg_cost <= k 的同时，给平台吸引到最多新用户
 */
public class Vivo1 {
    public static void main(String[] args) {
        int[] userIdList = {1,2,3,4,5};
        double[] costList = {2.0, 3.0, 1.0, 4.0, 2.0};
        double[] conversionList = {0.2, 0.1, 0.2, 0.1, 0.4};
        double avg_cost = 9.5;
        int[] arr = calculateUserList(userIdList,costList,conversionList,avg_cost);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] calculateUserList (int[] userIdList, double[] costList, double[] conversionList, double avg_cost) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = userIdList.length; //总期望转化用户数
        // 总期望转化用户数从多到少，当满足avg_cost<=k时，排序输出
        double k = avg_cost;
        ArrayList<Integer> path = new ArrayList<>();
        int num = n;
        int resIndex = 0;
        while(num>0){
//            n个人里选num个

            ArrayList<ArrayList<Integer>> comb = new ArrayList<>();
            backTracking(comb,path,n,num,1);

            for (int i = 0; i < comb.size(); i++) {
                ArrayList<Integer> arr = comb.get(i);
                double fee =0;
                for (int j = 0; j < arr.size(); j++) {
                    fee+=costList[arr.get(j)-1]*conversionList[arr.get(j)-1];
                }
                k = fee/num;
                if(k<=avg_cost){
                    for (int j = 0; j < comb.get(i).size() ; j++) {
                        res.add(comb.get(i).get(j));
                    }
                }
            }
            if(!res.isEmpty()) break;
            num--;
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    //存从n个用户里，选p个用户的组合

    public static void backTracking(ArrayList<ArrayList<Integer>> comb,ArrayList<Integer> path,int n,int p, int i){
        if(path.size()==p){
            comb.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j <= n; j++) {
            path.add(j);
            backTracking(comb,path,n,p,j+1);
            path.remove(path.size()-1);
        }
    }
}
