# offer59-1 ｜ leetcode239 滑动窗口的最大值
## 题目描述
![](offer59-1%20%EF%BD%9C%20leetcode239%20%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/%E6%88%AA%E5%B1%8F2021-02-20%2022.10.40.png)
## 问题分析
其实可以看作一个队列，每移动一步，一个元素入队，一个元素出队。但是每次都查找队列里的最大值的话，时间复杂度为k*(n-k+1)
## 解决方法
所以我们可以多维护一个单调递减队列

## 算法思想
1. 定义一个Queue,用于保存窗口内的k个元素
	1. 第一个窗口：先入队k个元素
	2. 每移动一步，进队一个元素，出队一个元素
	3. 如果出队元素和deque的队首元素相等，则deque队首元素也出队，保持数据一致

2. 定义一个Deque，维护Deque是一个单调递减队列，每一步（包括第一步）都判断：
	1. 如果Deque为空，元素x进队
	2. (while)若Deque不为空，且x大于队尾元素，则队尾元素出队
	3. 直到所有比x小的元素都不在了（从尾巴来看），x才进队

### 注意事项
1. 要判断nums为空，或者数据长度小于k的边界情况：
![](offer59-1%20%EF%BD%9C%20leetcode239%20%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/%E6%88%AA%E5%B1%8F2021-02-22%2013.11.03.png)
2. 判断相等不能用==，因为这里的队列用的是int的包装类Integer，所以要用.equals判断相等

## 复杂度分析
时间复杂度：O(n)，线性遍历nums占用O(N)；每个元素最多仅入队和出队一次，因此单调队列deque占用O(2N)

空间复杂度：O(k)双端队列deque中最多同时存储k个元素（即窗口大小）。

## 代码
```
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        if(nums==null || 0==nums.length || nums.length<k){
            int[] z = new int[0];
            return z;
        }
        int len =nums.length;
        int[] result = new int[len-k+1];
        int flag = 0;
        for (int i = 0; i < k ; i++) {
            queue.add(nums[i]);
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.pollLast();
            deque.add(nums[i]);
        }
        result[flag++] = deque.peekFirst();
        for (int i = k; i < len; i++) {
            queue.add(nums[i]);
            if(!deque.isEmpty() && deque.peekFirst().equals(queue.peek()))
                deque.pollFirst();
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.pollLast();

            deque.add(nums[i]);
            queue.poll();
            result[flag++] = deque.peekFirst();
        }
        return result;
    }
}
```