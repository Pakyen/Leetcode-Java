# offer06 从尾到头打印链表

![](offer06%20%E4%BB%8E%E5%B0%BE%E5%88%B0%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8/%E6%88%AA%E5%B1%8F2021-02-13%2022.32.26.png)
此题和offer24题反转链表类似，但需要注意的是这题的方法返回的是int[]
## 方法一 遍历
由于Java中数组不能改变长度，所以此题关键点在于要先知道链表的长度才能创建数组。其实可以用ArrayList，但是ArrayList转int数组还是需要遍历，花费的时间和空间都是O(N)。所以可以
	1. 先遍历链表，得到链表长度
	2. 创建数组
	3. 再遍历链表，倒序存入数组
	4. 返回数组
```
class Solution {
    public static int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
```
## 方法二：栈
这题其实很适合用栈，栈的特点是先进后出，所以此题用栈来解：
ps: 用栈的话，由于该方法返回的是int[]，也需要创建大小为size的数组，将节点存入，旨在学习栈的使用
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
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
			ListNode cur = head;
			while(cur!=null){
				stack.push(cur);
				cur = cur.next;
			}
			int size = stack.size();
			int[] result = new int[size];
			for(int i=0; i<size; i++){
				result[i] = stack.pop().val;
			}
			return result;
    }
}
```