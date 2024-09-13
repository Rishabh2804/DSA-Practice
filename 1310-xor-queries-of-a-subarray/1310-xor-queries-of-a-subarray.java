class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i = 1; i < arr.length; ++i)
            pre[i] = arr[i] ^ pre[i - 1];
        
        int[] res = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            
            if(l == 0) res[i ++] = pre[r];
            else res[i ++] = pre[l - 1] ^ pre[r];
        }
        
        return res;
    }
}