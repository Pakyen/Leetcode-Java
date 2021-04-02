package Sort;

public class shellSort {
    public void shellSort(int[] arr){
        for (int delta = arr.length/2; delta >=1 ; delta/=2) {
            for (int i = delta; i < arr.length; i++) {
                //注意每个地方增量和差值都是delta
                for (int j = i; j >=delta && arr[j]<arr[j-delta] ; j-=delta) {
                    swap(arr,j,j-delta);
                }
            }
        }
    }
    private void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
