class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String pre = countAndSay(n - 1);
        
        String res = "";
        int count = 1;
        char curr = pre.charAt(0);
        for(int i = 1; i < pre.length(); ++i){
            if(pre.charAt(i) == curr){
                count++;
                continue;
            }
            else{
                res += count;
                res += curr;
                count = 1;
                curr = pre.charAt(i);
            }                
        }
        
        return res + count + curr;
    }
}