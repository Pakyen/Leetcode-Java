# offer30 包含min函数的栈
参考：[力扣](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/)
和offer59-2是一样的思路
![](offer30%20%E5%8C%85%E5%90%ABmin%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88/%E6%88%AA%E5%B1%8F2021-02-19%2016.27.50.png)

### 解题思路
使用两个栈
栈A存放元素
栈B从大到小存放 [5,4,3,2,1 |

### 函数分析
* push(int x)
	* A直接入栈
	* B如果为空直接入栈，B如果不为空且栈内最后一个元素比x大，x才入栈（大于等于）
	如果B内最后一个元素比x小，x不入栈，这样能保证栈顶都是最小值
* pop()
【重点是保持栈A和栈B的元素一致】
如果B的最后一个元素和A的最后一个元素相等，那么两个栈都pop
如果不等，只pop A

* MinStack()
返回栈B的栈顶元素即可 B.peek()

* top()
返回栈A的栈顶元素即可 A.peek()

### 复杂度分析
![](offer30%20%E5%8C%85%E5%90%ABmin%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88/%E6%88%AA%E5%B1%8F2021-02-20%2022.01.48.png)

### 注意事项
	1. Java 代码中，由于 Stack 中存储的是 int 的包装类 Integer ，因此需要使用 equals() 代替 == 来比较值是否相等。
	2. 判断A和B栈顶元素时，使用的是A.pop().equals(B.peek())，这样可以简化代码
### 代码
```
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
class MinStack {
    Stack<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if(B.isEmpty() || x<=B.peek())
            B.add(x);
    }

    public void pop() {
        // 注意这里不能直接用==
        // 因为Stack中存储的是int的包装类Integer
        // 所以需要用equals()代替==来比较是否相等
        if(A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```