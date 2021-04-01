package Sort;

public class heapSort {

    private void heapSort(int[] arr){
        int len = arr.length -1; //注意，因为结点从0开始，所以len = n - 1
        buildMaxHeap(arr,len);
        for (int i = len; i >= 1 ; i--) {
            swap(arr,i,0);  //将堆顶元素和最后一位交换
            len -= 1;          //继续判断倒数第2、3.. ，直到根节点的左儿子
            maxHeapify(arr,0,len);
        }
    }

    // 自下而上建堆（完全二叉树）
    private void buildMaxHeap(int[] arr, int len){
        //从最后一个结点的父结点开始，直到根结点0，反复调整堆
        for (int i = len/2; i >=0 ; i--) {
            maxHeapify(arr,i,len);
        }
    }

    //自上而下调整堆（非递归）
    private void maxHeapify(int[] arr, int i, int len){

        for(; (i<<1) + 1 <= len ;){
            int left = (i<<1) +1 ; //左孩子，如果有的话
            int right = (i<<1) +2; //右孩子，如果有的话
            int large; //记录当前子树最大值的坐标

            if(left<=len && arr[left] > arr[i]) {
                large = left;
            }else{
                large = i;
            }
            if(right<=len && arr[right]>arr[large]){
                large = right;
            }
            if(large!=i){
                swap(arr,i,large);  //如果某个孩子更大，将结点上浮
                i = large;  //向下继续找大值
            }else{
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
