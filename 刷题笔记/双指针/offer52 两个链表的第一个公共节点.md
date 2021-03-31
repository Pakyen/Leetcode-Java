# offer52 两个链表的第一个公共节点
[力扣](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-14%2010.30.57.png)
![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-14%2010.31.05.png)
## 方法一 两次遍历
第一个想到的方法就是两次遍历，分别遍历两个链表，查到到intersectVal就break，返回长度。
	* 时间复杂度:O(N)
	* 空间复杂度:O(1)
但是这题有更妙的做法

## 方法二 双指针
参考：[力扣](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/)
![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/IMG_4733.HEIC)
所以我们可以设置两个指针，第一个指针走完len(A)后又指向HeadB，第二个指针走完len(B)后又指向HeadA，然后继续走。当他们都走完c1+c2+L的长度的时候，就是他们相遇的时候，这时候他们都指向公共节点。

> 边界：如果没有交点的话会在末尾的null处结束  

![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-14%2010.45.37.png)
![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-14%2010.45.52.png)
![](offer52%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-14%2010.46.02.png)
### Java实现：
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while(node1!=node2){
            if (node1==null) node1=headB;
            else node1 = node1.next;
            if (node2==null) node2=headA;
            else node2 = node2.next;
        }
        return node1;
    }
}
```