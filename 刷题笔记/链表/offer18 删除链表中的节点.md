# offer18 删除链表中的节点

![](offer18%20%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9/%E6%88%AA%E5%B1%8F2021-02-13%2022.24.46.png)
### 难点：
	1. 要注意边界值
		* 表头可能是val，所以要设置虚拟表头，最后返回virtualHead.next
		* 表尾可能是val，所以要在循环时加入判断，如果是表尾cur.next=null
### 算法思想：
	1. 设置虚拟表头，虚拟表头的next指向head
	2. 循环遍历链表
		1. 如果cur.next不是表尾，且cur.next是val，那么将cur.next指向cur.next.next
		2. 如果是表尾，cur.next=null
		3. 记得在循环体内最后加入cur = cur.next
		4. 因为题目中只有一个val值，且题目保证链表中节点的值互不相同，所以找到了就可以break
### 复杂度分析：
时间复杂度：O(N)，当表尾是val时，遍历链表，花费时间O(N)
空间复杂度：O(1)，新建的结点变量花费常数时间
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        ListNode cur = virtualHead;
        //注意边界值，head可能为null，所以需要设置一个虚拟表头
        while(cur.next!=null){
            if(cur.next.val==val){
                if(cur.next.next!=null)
                    //判断是否是表尾
                    cur.next = cur.next.next;
                else
                    cur.next = null;
            break;
            }
            cur = cur.next;
        }

        return virtualHead.next;
    }
}
```