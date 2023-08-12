class Solution {
        
    static final int SIZE = 10;
    static int[] factorial = new int[SIZE];
    
    private static void fact(){        
        factorial[0] = 1;        
        for(int i = 1; i < SIZE; ++i)
            factorial[i] = i * factorial[i - 1];
    } 
    
    public ArrayList<Integer> solve(int n, int k){ 
        if(n == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }
        
        int unit = factorial[n - 1];        
        
        int start = 1 + (k / unit);
        int k1 = k % unit;
        if(k1 == 0){
            start--;
            k1 = unit;
        }
        
        ArrayList<Integer> ans = solve(n - 1, k1);
        for(int i = 0; i < n - 1; ++i) {
            if(ans.get(i) >= start)
                ans.set(i, ans.get(i) + 1);                        
        }
        
        ans.add(start);
        return ans;
    }
    
    public String getPermutation(int n, int k) {
        if(factorial[0] == 0)
            fact();
        
        ArrayList<Integer> ans = solve(n, k);
        StringBuilder res = new StringBuilder();
        for(int i = ans.size() - 1; i >= 0; --i)
            res.append((char)(ans.get(i) + '0'));
        
        return res.toString();
    }
}