//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @author hbx
// * @date 2021-10-09 7:48 PM
// */
///*
//JD笔试1，工厂老张
//老张是一个工厂里的工人。他每天的工作就是坐在工厂流水线旁检查产品的质量。一天，流水线运来了一批产品，一共有n个，每个产品的质量用一个正整数ai表示。评价这些产品的好坏有一个“一致程度”的指标，“一致程度”指的是一批产品中质量相同的产品的最大个数。例如：如果一批产品的质量是“3 2 1 2 2 3”，质量为“1”的产品有1个，质量为“2”的产品有3个，质量为“3”的产品有2个，那么这批产品的“一致程度”就是3。现在老张需要从这些产品中选出一段连续的序列，使得该序列的“一致程度”与总的n个产品的“一致程度”相同，同时保证选出的序列长度最短。你能写一个程序实现这个操作吗？
//
//n个产品，每个产品有质量ai
//
//从产品中选出一段 连续 的 序列，
//使得该序列的 一致程度 与 总的n个产品的一致程度相同，同时保证选出的序列长度最短
// */
///*
//输入描述
//第一行有一个整数n，表示产品的数量。
//
//第二行有n个空格隔开的整数，每个整数表示一个产品的质量。
//
//输入保证只有一个答案符合要求。
//
//1≤n≤100000。
//
//1≤ai≤10000。
//
//输出描述
//输出两个整数，空格隔开，第一个整数表示所选序列的左端点的位置，第二个整数表示所选序列的右端点的位置。两个整数中间用一个空格隔开。
//
//样例输入
//6
//3 2 1 2 2 3
//样例输出
//2 5
//
//提示
//样例解释
//
//原数列的”一致程度”为3，所选序列从2到5，也就是“2 1 2 2”，其“一致程度”也为3，并且长度最短。
// */
///*
//注意，一致程度最高的数字不止有一个
// */
///*
//解题思路：
//1. 计算总序列的一致性程度，并记录一致性最高的数字有哪些。【并记录这些数字对应的第一个坐标和最后一个坐标】
//2. 遍历一致性最高的数字，计算他们的坐标差值，输出坐标差值最小的那一组
//3. 创建一个HashMap。【key为数字，value为一个长度为3的数组】。数组内容【count，左坐标，右坐标，长度】
// */
///*
//ac 91%
// */
//public class JD1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = in.nextInt();
//        }
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        int MaxCount = 1;
//        for (int i = 0; i < n; i++) {
//            if(map.isEmpty()||!map.containsKey(a[i])){
//                //如果没有，加进去，count = 1，记录左坐标
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(1);
//                list.add(i);
//                list.add(n);
//                list.add(n);
//                map.put(a[i],list);
//            }else if(map.containsKey(a[i])){
//                //如果有，count++，右坐标改变
//                //list
//                int count = map.get(a[i]).get(0);
//                int left = map.get(a[i]).get(1);
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(count+1);
//                list.add(left);
//                list.add(i);
//                list.add(i-left+1);
//                map.replace(a[i],list);
//                if(list.get(0)>MaxCount) MaxCount = list.get(0);
//            }
//        }
//        int minK = 0;
//        int minL = n;
//        for (Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
//            int key = entry.getKey();
//            ArrayList<Integer> list = entry.getValue();
//            int count = list.get(0);
//            if(count==MaxCount){
//                int l = list.get(3);
//                if (l<minL){
//                    minK = key;
//                    minL = l;
//                }
//            }
//        }
//        System.out.print(map.get(minK).get(1)+1);
//        System.out.print(' ');
//        System.out.print(map.get(minK).get(2)+1);
//    }
//}
