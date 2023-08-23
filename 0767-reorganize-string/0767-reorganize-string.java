class Solution {
    static final int CHAR = 0;
    static final int FREQ = 1;
    
    public String reorganizeString(String s) {        
        int n = s.length();
        
        int[] freq = new int[26];        
        for(int i = 0; i < n; ++i)
            freq[s.charAt(i) - 'a']++;
        
        // Arrays.sort(freq, (a, b) -> b[FREQ] - a[FREQ]);
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
        for(char c = 'a'; c <= 'z'; ++c)
            if(freq[c - 'a'] != 0) pq.offer(c);
        
        if(freq[pq.peek() - 'a'] > (n + 1) / 2) return "";
        
        StringBuilder res = new StringBuilder();        
        while(pq.size() > 1){
            char c1 = pq.poll();
            char c2 = pq.poll();
            
            res.append(c1);
            res.append(c2);
            
            if(--freq[c1 - 'a'] > 0) pq.offer(c1);
            if(--freq[c2 - 'a'] > 0) pq.offer(c2);
        }
        
        if(!pq.isEmpty()) res.append(pq.poll());
        return res.toString();
    }
}