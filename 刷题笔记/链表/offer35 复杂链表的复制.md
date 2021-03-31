# offer35 复杂链表的复制

[力扣](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)
![](offer35%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6/%E6%88%AA%E5%B1%8F2021-02-13%2018.54.24.png)![](offer35%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6/%E6%88%AA%E5%B1%8F2021-02-13%2018.55.07.png)
复制普通链表的话，只需要遍历复制当前节点和下一个节点的引用指向即可。
::这道题的难点在于，在复制链表的过程中构建新链表各节点的 random 引用指向::
![](offer35%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6/E930B148-23B2-4E46-AE63-4BCCAAAE7F80.png)
这里介绍 「哈希表」 ，「拼接 + 拆分」 两种方法。哈希表方法比较直观；拼接 + 拆分方法的空间复杂度更低。

## 方法一 哈希表
利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。

### 算法流程：	
	1. 若头节点 head 为空节点，直接返回 null
	
	2. 初始化： 哈希表 dic ， 节点 cur 指向头节点；

	3. 复制链表：
		1. 建立新节点，并向 dic 添加键值对 (原 cur 节点, 复制的新cur节点）；
		2. 遍历至原链表下一节点；

	4. 构建新链表的引用指向：
		1. 构建新节点的 next 和 random 引用指向；
		2. cur 遍历至原链表下一节点；

	5. 返回值： 新链表的头节点 dic[cur] ；
> 两遍遍历，第一遍遍历复制链表到哈希表中(原节点，新节点)从而构建新链表的节点，第二遍遍历构建新链表和next引用指向和random引用指向  

### 复杂度分析
	* 时间复杂度O(N)：两轮遍历链表，使用O(N)时间
	* 空间复杂度O(N)：哈希表dic使用线性大小的额外空间
```
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        //3.复制各个节点，并建立"原节点->新节点"的映射
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //4.构建next和random指向
        //因为HashMap无序，且查询快，所以可以直接在HashMap中查询到cur.next并指给新节点的next
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
```

## 方法二 拼接+拆分
![](offer35%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6/%E6%88%AA%E5%B1%8F2021-02-13%2021.03.45.png)
因为这样的话，不需要新构建HashMap，没有额外的空间占用。
并且，复制的新节点cur.next的next就是cur.next.next
新节点的随机指向节点就是cur.random.next
【cur.next.random = cur.random.next】
![](offer35%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6/%E6%88%AA%E5%B1%8F2021-02-13%2021.06.49.png)
所以一共需要遍历三遍：
	1. 第一遍遍历，复制各个节点，构建新链表
	2. 构建新节点的random指向
	3. 拆分链表，分离新旧链表
### 复杂度分析
	* 时间复杂度O(N)：三轮遍历链表，使用O(N)时间
	* 空间复杂度O(1)：节点引用变量使用常数大小的额外空间
```
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
```

