package Sort;

public class MergeSort {
    // tmp 是一个和arr一样大小的新数组
    //初始 int[] tmp = new int[arr.length]
    // left = 0, right = arr.length-1

    public static void mergeSort(int[] arr, int[] tmp, int left, int right){
        if(left<right){
            int middle = (left+right)/2;
            mergeSort(arr, tmp, left, middle); //左子数组
            mergeSort(arr, tmp, middle+1, right); //右子数组
            mergeArray(arr, tmp, left, middle, right); //合并两个数组
        }
    }
    //合并两个有序子序列
    private static void mergeArray(int[] arr, int[] tmp, int left, int middle, int right){
        int i = left;
        int j = middle + 1 ;
        int k = 0;
        //对两个指针，谁小，就放谁进新的有序数组
        while(i<=middle && j<=right){
            tmp[k++] = arr[i]<=arr[j] ? arr[i++]:arr[j++];
        }
        //如果i没放完，就把剩下的元素放进去
        while(i<=middle){
            tmp[k++] = arr[i++];
        }
        while(j<=right){
            tmp[k++] = arr[j++]; //j同理
        }
        //把数组复制回原来的数组
        for (i = 0; i < k; i++) {
            arr[left+i] = tmp[i];
        }
    }
}
