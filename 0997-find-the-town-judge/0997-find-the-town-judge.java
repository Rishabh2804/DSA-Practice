class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] trusts = new int[n];
        int[] trustedBy = new int[n];
        
        for(int[] t : trust){
            int a = t[0] - 1;
            int b = t[1] - 1;
            
            trusts[a]++;
            trustedBy[b]++;
        }
        
        int judge = -1;
        for(int i = 0; i < n; ++i){
            if(trusts[i] == 0 && trustedBy[i] == n - 1){
                if(judge == -1) judge = i + 1;
                else return -1;
            }
        }
        
        return judge;
    }
}