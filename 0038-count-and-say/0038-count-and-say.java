class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        String pre = countAndSay(n - 1);
        
        StringBuilder res = new StringBuilder();
        int count = 1;
        char curr = pre.charAt(0);
        for(int i = 1; i < pre.length(); ++i){
            if(pre.charAt(i) == curr){
                count++;
                continue;
            }
            else{
                res.append(count);
                res.append(curr);                
                count = 1;
                curr = pre.charAt(i);
            }                
        }
        
        res.append(count);
        res.append(curr);
            
        return res.toString();
    }
}