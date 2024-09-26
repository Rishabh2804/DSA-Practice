class MyCalendar {

    static class Pair{
        int start;
        int end;
        
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    LinkedList<Pair> events;
    
    public int lower_bound(LinkedList<Pair> array, int key)
    {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.size();
        int mid;
 
        // Till high does not crosses low
        while (low < high) {
 
            // Find the index of the middle element
            mid = low + (high - low) / 2;
 
            // If key is less than or equal
            // to array[mid], then find in
            // left subarray
            if (key <= array.get(mid).end) {
                high = mid;
            }
 
            // If key is greater than array[mid],
            // then find in right subarray
            else {
 
                low = mid + 1;
            }
        }
 
        // If key is greater than last element which is
        // array[n-1] then lower bound
        // does not exists in the array
        if (low < array.size() && array.get(low).end < key) {
            low++;
        }
 
        // Returning the lower_bound index
        return low;
    }
    
    
    public MyCalendar() {
        events = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        if(events.isEmpty()){
            events.add(new Pair(start, end));
            return true;
        }
        
        int index = lower_bound(events, end);
        int preEnd = Integer.MIN_VALUE, postStart = Integer.MAX_VALUE;
        if(index > 0)
            preEnd = events.get(index - 1).end;
        
        if(index < events.size())
            postStart = events.get(index).start;
        
        if(start >= preEnd && end <= postStart){
            events.add(index, new Pair(start, end));
            return true;
        }
        else
            return false;        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */