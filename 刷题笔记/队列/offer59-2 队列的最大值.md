# offer59-2 队列的最大值
![](offer59-2%20%E9%98%9F%E5%88%97%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/%E6%88%AA%E5%B1%8F2021-02-19%2014.27.28.png)
参考：[力扣](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/jian-zhi-offer-59-ii-dui-lie-de-zui-da-z-0pap/)

## 解题思路
> 对于普通队列，入队 push_back() 和出队 pop_front() 的时间复杂度均为 O(1) ；本题难点为实现查找最大值 max_value()的 O(1) 时间复杂度  
>   
> 假设队列中存储 N 个元素，从中获取最大值需要遍历队列，时间复杂度为 O(N) ，单从算法上无优化空间  

最直观的思路是**维护一个最大值变量** ，在元素入队时更新此变量即可；但当最大值出队后，并无法确定下一个 **次最大值** ，因此不可行
![](offer59-2%20%E9%98%9F%E5%88%97%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/1FFA2D05-39A0-4CD0-98D7-608A72A10B61.png)
考虑利用 数据结构 来实现，即经常使用的 “空间换时间” 。如下图所示，考虑构建一个递减列表来保存队列 所有递减的元素 ，递减链表随着入队和出队操作实时更新，这样队列最大元素就始终对应递减列表的首元素，实现了获取最大值 O(1) 时间复杂度。
![](offer59-2%20%E9%98%9F%E5%88%97%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/3223BB0B-B76A-4093-8075-401B6A636BC0.png)
为了实现此递减列表，需要使用 双向队列 ，假设队列已经有若干元素：

	1. 当执行入队 push_back() 时： 若入队一个比队列某些元素更大的数字 x，则为了保持此列表递减，需要将双向队列尾部所有小于 x 的元素弹出。
	
	2. 当执行出队 pop_front() 时： 若出队的元素是最大元素，则 双向队列 需要同时 将首元素出队 ，以保持队列和双向队列的元素一致性。
> 使用双向队列原因：维护递减列表需要元素队首弹出、队尾插入、队尾弹出操作皆为*O*(1) 时间复杂度  

### 函数设计
初始化队列queue，双向队列deque;

* 最大值max_value()
	* 当双向队列deque为空，则返回-1；
	* 否则，返回deque首元素;

* 入队 push_back()
	1. 将元素value入队queue；
	2. 将deque中，所有小于value的元素弹出（保持deque递减），并将元素value入队deque;

* 出队pop_front()
	1. 若队列queue为空，则返回-1；
	2. 否则，将queue首元素出队
	3. 若deque首元素和queue首元素相等，说明出队的是最大值，那么deque首元素也要出队（以保持两个队列元素一致）

### 为什么这么设计可以？
⚠️本题有一个非常重要的点是，deque中，在插入value时，比value小的值从尾部出来时，是不会再进队列的了。因为这些比value小的值，不再会对最大值产生影响。
这是为什么呢？
> 因为value在这些比它小的值后面进去queue，所以queue中前面的比value小的元素出队列的时候，最大值还是value，所以不需要再将它们push进队列deque  
![](offer59-2%20%E9%98%9F%E5%88%97%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/%E6%88%AA%E5%B1%8F2021-02-19%2015.45.17.png)
视频解释：[力扣](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/yi-miao-jiu-neng-du-dong-de-dong-hua-jie-b4de/)
### 复杂度分析
![](offer59-2%20%E9%98%9F%E5%88%97%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC/%E6%88%AA%E5%B1%8F2021-02-19%2015.46.40.png)

### 代码
```
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value(){
        return deque.isEmpty() ? -1:deque.peekFirst();
    }
    //关于queue的方法，不抛出异常的，是：offer插入，poll获取并删除，peek获取但不删除
    //关于deque的方法，不抛出异常的，就加上First, Last
    public void push_back(int value){
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast()<=value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    public int pop_front(){
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
```



