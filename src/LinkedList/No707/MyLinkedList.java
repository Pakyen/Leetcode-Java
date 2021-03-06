package LinkedList.No707;
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

//单链表
    //节点的定义
public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
//链表的定义和方法
class MyLinkedList {
    int size;//链表大小
    ListNode head; //虚拟表头
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 | index>=size) return -1;

        ListNode curr = head;
        // 需要考虑到虚拟表头
        for (int i = 0; i <index+1 ; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        //要在表头加节点，只要把虚拟节点的next指向新节点
        //新节点的next指向原本的第一个节点即可
//        ListNode x = new ListNode(val);
//        x.next = head.next;
//        head.next = x;
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //虚，1,3 -> add(1,2) -> 虚，1, 2, 3 -> (第1个节点的后面,2)
        if(index>size) return;
        if(index<0) index=0;

        size++; //因为不满足上述条件就肯定要增加一个节点

        //找到要添加的位置的前面那个节点
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }

        //创建需要被添加的节点
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size|index<0) return;

        size--;//因为不满足上述条件就肯定要删除一个节点

        //找到需要删除的节点的前一个节点
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        //删除节点
        pred.next = pred.next.next;

    }
}

