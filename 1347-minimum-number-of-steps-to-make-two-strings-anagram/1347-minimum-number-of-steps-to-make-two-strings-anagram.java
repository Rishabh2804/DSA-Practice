class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        
        for(int i = 0; i  < s.length(); ++i)
            freq[s.charAt(i) - 'a']++;
        
        for(int i = 0; i  < s.length(); ++i)
            freq[t.charAt(i) - 'a']--;
        
        int sum = 0;
        for(int i : freq){
            if(i >= 0) sum += i;
        }
        
        return sum;
    }
}

// 1 1 -1 -2 1 -1 1 1 

// a c d e i l o p r t
// -1 -1 1 2 -1 1 1 -1 -1 0