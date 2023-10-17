class Solution {
    private int traverse(int curr, int[] leftChild, int[] rightChild, boolean[] vis){
        if(curr == -1) return 0;
        if(vis[curr]) return -1;
        
        vis[curr] = true;
        
        int left = traverse(leftChild[curr], leftChild, rightChild, vis);
        if(left == -1) return -1;
        
        int right = traverse(rightChild[curr], leftChild, rightChild, vis);        
        if(right == -1) return -1;        
        
        return 1 + left + right; 
    }
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] vis = new boolean[n];
        
        boolean validation = false;
        for(int i = 0; i < n; ++i){
            validation |= traverse(i, leftChild, rightChild, new boolean[n]) == n;
            
            if(validation == true) return true;
        }
        
        return validation;
    }
}