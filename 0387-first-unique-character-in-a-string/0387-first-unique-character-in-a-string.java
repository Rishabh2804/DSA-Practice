class Solution {
    public int firstUniqChar(String s) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, s.length() + 1);
        
        for(int i = 0; i < s.length(); ++i){
            int index = s.charAt(i) - 'a';
            if(alpha[index] != s.length() + 1)
                alpha[index] = s.length();
            else
                alpha[index] = i;
        }
        
        int ans = s.length();
        for(int i : alpha)
            ans = Math.min(ans, i);
        
        if(ans >= s.length())
            return -1;
        else
            return ans;        
    }
}