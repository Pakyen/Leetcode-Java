package Sort;

public class insertionSort {
    public static void insertionSort(int[] arr){
        int tmp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j] < arr[j-1]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }else{
                    break;
                }
            }
        }
    }
}
