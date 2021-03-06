package Heap.offer40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || k==0)
            return new int[0];
        if(arr.length<=k)
            return arr;
        quick_sort(arr,k,0,arr.length-1);
    }
    private int[] quick_sort(int[] arr, int k, int left, int right){
        int i=left, j=right;
        while(i<j){
            while(i<j && arr[j] >= arr[left]) j--;
            while(i<j && arr[i] <= arr[left]) i++;
            //从右边看，比哨兵大的节点不动，指针j--，直到右边有比哨兵小的节点
            //从左边看，比哨兵小的节点不动，指针i++，直到左边有比哨兵大的节点
            //交换i, j, 继续循环
            swap(arr,i,j);
        }
        //最终i和j指向同一个位置，交换i和left的元素
        swap(arr,i,left);
        if(i>k) return quick_sort(arr,k,left,i-1);
        if(i<k) return quick_sort(arr,k,i+1,right);
        //注意：不要返回原数组，要返回copy
        return Arrays.copyOf(arr,k);
    }
    private void swap(int[] arr, int i, int j){
        int t=arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
//public class Solution{
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if(arr==null || k==0)
//            return new int[0];
//
//        //使用一个最大堆
//        //Java的PriorityQueue默认是最小堆，实现大根堆需要重写一下比较器，可以用lambda
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
//        //return a-b代表升序，最小堆
//        //return b-a代表降序，最大堆
//        for(int num:arr){
//            if(heap.size()<k)
//                heap.offer(num);
//            else if(num<heap.peek()){
//                heap.poll();
//                heap.offer(num);
//            }
//        }
//        //返回堆中元素
//        int[] res = new int[heap.size()];
//        int idx=0;
//        for(int num:heap)
//            res[idx++] = num;
//        return res;
//    }
//}
