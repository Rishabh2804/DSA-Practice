class Solution {
    
    public int minDeletions(String s) {
        int[][] freq = new int[26][2];
        
        int curr = 0;
        for(int[] ele : freq)
            ele = new int[]{curr++, 0};
        
        for(int i = 0; i < s.length(); ++i)
            freq[s.charAt(i) - 'a'][1]++;
        
        Arrays.sort(freq, (a, b) -> a[1] - b[1]);
        
        int deletions = 0;
        
        int si = 0; 
        HashSet<Integer> set = new HashSet<>();
        for(int[] ele : freq){
            if(ele[1] == 0) continue;
            
            int j = ele[1];
            while(set.contains(j)) j--;
                
            deletions += ele[1] - j;
            if(j != 0) 
                set.add(j); 
        }
        
        return deletions;
    }
}