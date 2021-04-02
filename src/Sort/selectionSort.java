package Sort;

public class selectionSort {
    public static void selectionSort(int[] arr){
        int tmp, minIndex=0;
        int n = arr.length;
        for (int i = 0; i < n-1 ; i++) {
            minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(arr[minIndex]>arr[j]) minIndex = j;
            }
            if(minIndex!=i){
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
