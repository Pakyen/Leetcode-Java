package Queue.offer59_1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        if(nums==null || 0==nums.length || nums.length<k){
            int[] z = new int[0];
            return z;
        }
        int len =nums.length;
        int[] result = new int[len-k+1];
        int flag = 0;
        for (int i = 0; i < k ; i++) {
            queue.add(nums[i]);
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.pollLast();
            deque.add(nums[i]);
        }
        result[flag++] = deque.peekFirst();
        for (int i = k; i < len; i++) {
            queue.add(nums[i]);
            if(!deque.isEmpty() && deque.peekFirst().equals(queue.peek()))
                deque.pollFirst();
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.pollLast();

            deque.add(nums[i]);
            queue.poll();
            result[flag++] = deque.peekFirst();
        }
        return result;
    }
}