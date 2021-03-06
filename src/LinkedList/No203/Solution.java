package LinkedList.No203;
import ListNode.java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; //数据
 *     ListNode next; //指向下一个节点的指针
 *     ListNode(int x) { val = x; } //构造函数
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode VirtualNode = new ListNode(0);
        VirtualNode.next = head;

        ListNode prev = VirtualNode;
        ListNode curr = head;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }
            else{
                prev = curr;
            }
            curr = curr.next;
        }
        return VirtualNode.next; //返回
    }
}