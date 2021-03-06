package Heap.offer41;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> A,B;
    public MedianFinder() {
        A = new PriorityQueue<>(); //小顶堆A，保存较大的一半
        B = new PriorityQueue<>((a,b)->(b-a));//大顶堆B，保存较小的一半
    }

    public void addNum(int num) {
        if(A.size()==B.size()){
            //N为偶数，要将元素插入A中。不过要先插入num插入B中，再将B顶插入A中
            B.add(num);
            A.add(B.poll());
        }
        else{
            //N为基数，插入B中。不过要先插入A中，再将A顶插入B中
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        return A.size()==B.size() ? ((A.peek()+B.peek())/2.0) : A.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */