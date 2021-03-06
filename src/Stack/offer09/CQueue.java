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
