package Queue.offer59_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value(){
        return deque.isEmpty() ? -1:deque.peekFirst();
    }
    //关于queue的方法，不抛出异常的，是：offer插入，poll获取并删除，peek获取但不删除
    //关于deque的方法，不抛出异常的，就加上First, Last
    public void push_back(int value){
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast()<=value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    public int pop_front(){
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
