class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compare(b, a));
        
        for(String num : nums)
            pq.add(num);
        
        while(k --> 1)
            pq.poll();
        
        return pq.poll();
    }
    
    public int compare(String a, String b){
        if(a.length() > b.length())
            return 1;
        else if(b.length() > a.length())
            return -1;
        
        return a.compareTo(b);
    }
}