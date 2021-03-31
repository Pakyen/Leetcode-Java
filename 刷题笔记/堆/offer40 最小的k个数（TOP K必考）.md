# offer40 最小的k个数（TOP K必考）
::会考有哪些思路，时间复杂度和空间复杂度是多少，还会考底层实现原理::
![](offer40%20%E6%9C%80%E5%B0%8F%E7%9A%84k%E4%B8%AA%E6%95%B0%EF%BC%88TOP%20K%E5%BF%85%E8%80%83%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-22%2013.34.03.png)
四种方法解决top k问题
* 快速排序（::背好模版::）
* 快速排序变形
* 堆
* 二叉搜索树
* 数据范围有限时直接计数排序
- - - -
# 快速排序
[快速排序算法_哔哩哔哩 (゜-゜)つロ 干杯~-bilibili](https://www.bilibili.com/video/BV1at411T75o?from=search&seid=41017057757868532)
1. 选取任意一个元素座位中心轴Pivot，一般选最左边的第一个元素
2. 将大于中心轴的数据放在右边，小于中心轴的数字放在左边
3. 分别对左右子序列重复前面的操作，知道子序列长度为1（默认长度为1是有序序列）
- - - -
# 方法1 快速排序变形
[力扣](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/)
![](offer40%20%E6%9C%80%E5%B0%8F%E7%9A%84k%E4%B8%AA%E6%95%B0%EF%BC%88TOP%20K%E5%BF%85%E8%80%83%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-22%2014.01.19.png)
## 算法流程
`getLeastNumbers()函数`
	1. 若k>数组长度，直接返回整个数组
	2. 执行返回`quick_sort()`即可

`quick_sort`
> 注意，这里的quick_sort功能不是排序整个数组，而是搜索返回最小的k个数  
	1. 哨兵划分：
		* 划分完毕后，基准数为arr[i]，左/右子区间为[left,i-1], [i+1, right]
> 		  i表示哨兵的位置  
	2. 递归或返回：
		* 若k<i，代表第k+1小的数字在左子数组中，则递归左子数组
		* 若k>i，代表第k+1小的数字在右子数组中，则递归右子数组
		* 若k==i，代表此时arr[k]就是第k+1小的数字，直接返回数组的前7个数字即可
![](offer40%20%E6%9C%80%E5%B0%8F%E7%9A%84k%E4%B8%AA%E6%95%B0%EF%BC%88TOP%20K%E5%BF%85%E8%80%83%EF%BC%89/0C3618D8-6932-4F7C-9F37-DFAB6DB1DB92.png)
> **复杂度分析：**  
> 本方法优化时间复杂度的本质是通过判断舍去了不必要的递归（哨兵划分）。  
![](offer40%20%E6%9C%80%E5%B0%8F%E7%9A%84k%E4%B8%AA%E6%95%B0%EF%BC%88TOP%20K%E5%BF%85%E8%80%83%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-22%2014.10.13.png)

```
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || k==0)
            return new int[0];
        if(arr.length<=k)
            return arr;
        return quick_sort(arr,k,0,arr.length-1);
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
        //注意：不要返回原数组,因为数组长度不可变，要返回copyOf
        return Arrays.copyOf(arr,k);
    }
    private void swap(int[] arr, int i, int j){
        int t=arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
```

## 方法二 快速排序（背模版）
```
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

```

### 方法3 堆
[力扣](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/)
比较直观的想法是使用堆数据结构来辅助得到最小的 k 个数。堆的性质是每次可以找出最大或最小的元素。我们可以使用一个大小为 k 的最大堆（大顶堆），将数组中的元素依次入堆（x<=堆顶，才入堆），当堆的大小超过 k 时，便将多出的元素从堆顶弹出。
这样，**由于每次从堆顶弹出的数都是堆中最大的，最小的 k 个元素一定会留在堆里**
![](offer40%20%E6%9C%80%E5%B0%8F%E7%9A%84k%E4%B8%AA%E6%95%B0%EF%BC%88TOP%20K%E5%BF%85%E8%80%83%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-22%2015.00.25.png)
::Java实现最小堆：::
```
//使用一个最大堆
//Java的PriorityQueue默认是最小堆，实现大根堆需要重写一下比较器，可以用lambda
PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
//return a-b代表升序，最小堆
//return b-a代表降序，最大堆
```
代码：
```
public class Solution{
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || k==0)
            return new int[0];

        //使用一个最大堆
        //Java的PriorityQueue默认是最小堆，实现大根堆需要重写一下比较器，可以用lambda
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        //return a-b代表升序，最小堆
        //return b-a代表降序，最大堆
        for(int num:arr){
            if(heap.size()<k)
                heap.offer(num);
            else if(num<heap.peek()){
                heap.poll();
                heap.offer(num);
            }
        }
        //返回堆中元素
        int[] res = new int[heap.size()];
        int idx=0;
        for(int num:heap)
            res[idx++] = num;
        return res;
    }
}
```