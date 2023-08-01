class Solution {
    
    // using Pascal's triangle 
    // A(n, k) = A(n - 1, k - 1) + A(n - 1, k)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans;
        if(k == 1) {
            ans = new ArrayList<>();
            for(int i = 1; i <= n; ++i){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                ans.add(temp);
            }
            
            return ans;
        }
        
        if(n == k){
            ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= n; ++i)
                temp.add(i);
            
            ans.add(temp);
            return ans;
        }
        
        ans = combine(n - 1, k);
        List<List<Integer>> subAns2 = combine(n - 1, k - 1);
        
        for(List<Integer> comb : subAns2){
            comb.add(n);                  
            ans.add(comb);
        }
        
        return ans;
    }
}