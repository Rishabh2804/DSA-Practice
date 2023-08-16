class Solution {
    
    static class MyQueue {
        static class QNode {
            int val;
            int idx;
            
            QNode prev;
            QNode next;
                
            QNode(int val, int idx){
                this.val = val;
                this.idx = idx;
            }            
        }
        
        private QNode front;
        private QNode rear;
        
        public int getFrontIndex(){
            // although will never happen
            if(front == null) 
                return -1;
            
            return front.idx;
        }
        
        public void enqueue(int val, int idx){
            QNode curr = new QNode(val, idx);
            
            while(rear != null && rear.val <= val){
                rear = rear.prev;
                
                if(rear == null)
                    break;
                
                rear.next = null;
            }
            
            if(rear == null){
                rear = curr;
                front = rear;
            } else{
                rear.next = curr;
                curr.prev = rear;
                
                rear = curr;
            }
        }
        
        public void dequeue(){
            if(front == null) return;
            else {
                front = front.next;
                front.prev = null;
            }
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        
        MyQueue que = new MyQueue();
        for(int i = 0; i < k; ++i)
            que.enqueue(nums[i], i);
        
        int[] max = new int[nums.length - k + 1];
        max[0] = nums[que.getFrontIndex()];
        
        int j = 1;        
        for(int i = k; i < nums.length; ++i){
            que.enqueue(nums[i], i);
            
            int frontIdx = que.getFrontIndex();
            if(i - frontIdx + 1 > k){ // interval length > k
                que.dequeue();
                frontIdx = que.getFrontIndex();
            }
            
            max[j++] = nums[frontIdx];            
        }
        
        return max;
    }
}