class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[]{0};
        
        int[] ans = new int[n + 1];
        
        ans[1] = 1;
        for(int i = 1; i <= n; ++i){
            int leftChild = i << 1;
            int rightChild = 1 + leftChild;
            
            if(leftChild <= n)
                ans[leftChild] = ans[i];
            
            if(rightChild <= n)
                ans[rightChild] = 1 + ans[i];
        }
        
        return ans;
    }
}