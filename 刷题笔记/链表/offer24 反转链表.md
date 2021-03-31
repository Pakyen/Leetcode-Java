# offer24 反转链表
![](offer24%20%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8/%E6%88%AA%E5%B1%8F2021-02-13%2021.29.08.png)
假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3。
在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
![](offer24%20%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8/%E6%88%AA%E5%B1%8F2021-02-13%2021.43.13.png)
1. 先存一下下一个节点 tmp = cur.next
2. 当前节点的next指向上一个节点，cur.next = pre
3. pre存放当前节点
4. cur = tmp; 继续进行循环，直到cur = null
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

```