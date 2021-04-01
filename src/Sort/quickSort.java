package Sort;

public class quickSort {

    private void quickSort(int[] arr, int l, int r){
        if(l>=r) return;    //子数组长度为1时终止递归
        int i=l, j=r;
        //划分
        while(i<j){
            //从右向左找第一个小于pivot的值
            while(i<j && arr[j]>=arr[l]) j--;
            //从左向右找第一个大于pivot的值
            while(i<j && arr[i]<=arr[l]) i++;
            //将i，j交换：小的数放左边，大的数放右边
            swap(arr,i,j);
        }
        //将i和l交换，把pivot换到i位置，划分空间 [l, i-1] [i+1, r]
        swap(arr,i,l);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
