package Stack.offer30;

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