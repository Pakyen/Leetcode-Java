package LinkedList.offer.offer18;

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