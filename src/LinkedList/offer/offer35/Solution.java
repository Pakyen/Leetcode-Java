package LinkedList.offer.offer35;
import java.util.HashMap;
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//class Cqueue {
//    public Node copyRandomList(Node head) {
//        if(head==null) return null;
//        Node cur = head;
//        Map<Node,Node> map = new HashMap<>();
//        //3.复制各个节点，并建立"原节点->新节点"的映射
//        while(cur!=null){
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        //4.构建next和random指向
//        //因为HashMap无序，且查询快，所以可以直接在HashMap中查询到cur.next并指给新节点的next
//        while(cur!=null){
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }
//}
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur = head;
        //1 构造新链表
        while(cur!=null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        //2构建新链表random指向
        cur = head;
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分新旧链表
        Node pre = head;
        cur = head.next;
        Node result = cur;
        //如果head!=null
        //新链表的结尾应该是：Node -> newNode -> null
        //所以用cur.next!=null 来作为循环条件
        while(cur.next!=null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //注意，还需要处理原链表的尾节点，因为题目中链表尾是指向null的
        pre.next = null;
        return result;
    }
}









