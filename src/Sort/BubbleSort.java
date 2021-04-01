package Sort;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swap;
        int tmp;
        for (int i = 0; i < n-1; i++) {

            swap = false;

            for (int j = 0; j < n-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swap = true;
                }
            }
            if(!swap) break;

        }
    }
}
