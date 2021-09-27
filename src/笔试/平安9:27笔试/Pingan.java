import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-09-27 7:23 PM
 */
/*
就一题，题目是写个快排，ac100%
 */
public class Pingan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] number = str.split(",");
        int[] arr = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            arr[i] = Integer.parseInt(number[i]);
        }
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1){
                System.out.print(arr[i]);
                System.out.print(',');
            }else{
                System.out.println(arr[i]);
            }
        }
    }
    private static void quickSort(int[] arr, int l, int r){
        if(l>=r) return;
        int i=l, j=r;
        while(i<j){
            //从右往左，找第一个小于pivot的值
            while(i<j && arr[j]>=arr[l]) j--;
            //从左往右，找第一个大于pivot的值
            while(i<j && arr[i]<=arr[l]) i++;
            //i,j交换。此时，i小, pivot, j大
            swap(arr,i,j);
        }
        //i和l交换，pivot为l
        swap(arr,i,l);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
