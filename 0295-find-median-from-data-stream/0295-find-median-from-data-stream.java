class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    double median;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        median = 0;        
    }
    
    public void addNum(int num) {
        if(left.size() <= right.size()){
            right.add(num);
            left.add(right.poll());
        }
        else {
            left.add(num);
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size())
            return (double)(left.peek() + right.peek()) / 2;
        else if(left.size() > right.size())
            return (double)left.peek();
        else
            return (double)right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */