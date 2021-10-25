//import java.util.ArrayList;
//import java.util.HashSet;
//
///**
// * @author hbx
// * @date 2021-10-23 10:29 AM
// *//*
// 小红书邀请用户参与新兴线下生活方式的体验活动，每个活动有编号从1到n。每个活动之间有依赖关系，例如滑雪III（编号5）依赖滑雪II（编号3），[3,5]表示用户需要先完成3再完成5。为方便大家使用，组委会提供了一个查询依赖的功能，该功能输入[x,y]，若x是y需要进行的前置活动，则返回true。请实现这一功能
// */
//    /*
//    输入描述
//n = 5
//
//relations = [[1,3], [1,2], [3,2], [2,4], [3,5]]
//
//queries = [[1,5], [1,4], [4,5], [4,2]]
//
//输出描述
//[1, 1, 0, 0]
//     */
//
///*
//样例输入
//5
//5 2
//1 3
//1 2
//3 2
//2 4
//3 5
//4 2
//1 5
//1 4
//4 5
//4 2
//样例输出
//1 1 0 0
//
//提示
//2 <= n <= 100
//
//1 <= queries.length <= 10^3
//
//queries[i][0] != queries[i][1]
//
//图中不存在环
// */
//public class red1 {
//    public static void main(String[] args) {
//        int n = 5;
//        int[][] relations = {
//                {1,3},{1,2},{3,2},{2,4},{3,5},{4,2}
//        };
//        int[][] queries = {
//                {1,5},{1,4},{4,5},{4,2}
//        };
//        int[] res = new int[4];
//        res = checkDependency(n,relations,queries);
//        for (int i = 0; i < res.length; i++) {
//            System.outa.println(res[i]);
//        }
//    }
//
//    public static int[] checkDependency(int n, int[][] relations, int[][] queries) {
//        int m = queries.length;
//        int[] res = new int[m];
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < n+1; i++) {
//            list.add(new ArrayList<>());
//        }
//        for (int i = 0; i < n; i++) {
//            int x = relations[i][0];
//            int y = relations[i][1];
//            ArrayList<Integer> s = list.get(y); //第y个set
//            s.add(x);
//            list.remove(y);
//            list.add(y,s);
//        }
//
//        for (int i = 0; i < m; i++) {
//            //m个查询
//            res[i] = 0;
//            int x = queries[i][0];
//            int y = queries[i][1];
//            ArrayList<Integer> s = list.get(y);
//            for (int j = 0; j < s.size(); j++) {
//                if(s.get(i)==x){
//                    res[i] = 1;
//                    break;
//                }
//                else{
//                    ArrayList<Integer> s2 = list.get(s.get(i));
//                    for (int k = 0; k < s2.size(); k++) {
//                        if(s2.get(k)==x){
//                            res[i]=1;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}
//
//
//
//
//
//
//
