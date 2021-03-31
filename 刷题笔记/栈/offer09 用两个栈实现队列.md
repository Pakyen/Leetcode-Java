# offer09 用两个栈实现队列
![](offer09%20%E7%94%A8%E4%B8%A4%E4%B8%AA%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97/%E6%88%AA%E5%B1%8F2021-02-17%2011.41.56.png)
要解决这道题首先要知道栈和队列的相同点和不同点：
详见： [[栈和队列的区别]]

### 解题思路
	
	* 栈无法实现队列功能:
		栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈
	* 双栈可实现列表倒序:
		设有两个栈，栈A存放元素，出栈时，讲栈A出栈的元素存入空栈B中，再将B栈中元素出栈即可实现先进先出
			1. 如 A=[1,2,3] B=[]
			2. A中元素出栈存入B，A=[], B=[3,2,1]
			3. B中元素出栈，依次得到[1,2,3]
	* 利用栈B删除队首元素
	B中元素出栈就相当于删除了A的栈底元素（对应队首元素）

### 函数设计
	* appendTail：在队尾插入整数
		将数字入栈A即可
	* deleteHead：删除队首元素
		⚠️ 这里分三种情况
		1. 当栈B为空时：
			1. 若A为空，证明没有元素，返回-1
			2. ::若B为空，A不为空，将栈A的元素全部转移至栈B中，并返回B的栈顶元素::【这里很容易忽视，要注意】
		2. 当栈B不为空时：
			1. 说明B中已经有完成倒序的元素，直接返回B的栈顶元素即可

### 复杂度分析
	* 时间复杂度：
		* appendTail()函数为O(1)
		* deleteHead()函数为O(N)
	* 空间复杂度：O(N)
	最差情况下，栈A和B一共保存了N个元素

### 代码
```
package Stack.offer09;

import java.util.LinkedList;

class CQueue {
    LinkedList<Integer> A,B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if(B.isEmpty()&&A.isEmpty()) return -1;
        if(B.isEmpty()&&!A.isEmpty()){
            while(!A.isEmpty()){
                B.addLast(A.removeLast());
            }
        }
        return B.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```