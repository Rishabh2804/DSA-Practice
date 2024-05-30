class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        
        HashMap<Integer, Integer> xor = new HashMap<>();
        xor.put(0, -1);
        
        int count = 0;
        
        for(int i = 0; i < n; ++i){            
            for(int k = i + 1; k < n; ++k){
                
                int total = 0;
                for(int j = i; j <= k; ++j) total ^= arr[j];
                
                int curr = arr[i];
                for(int j = i + 1; j <= k; ++j){
                    curr ^= arr[j];
                    
                    int rest = total ^ curr;
                    
                    if(curr == rest) count++;
                }
            }            
        }
        
        
//         for(int i = 0; i < n; ++i){
//             if(i > 0) pre[i] = pre[i - 1] ^ arr[i];
            
//             if(xor.containsKey(pre[i])){
                
//                 int si = xor.get(pre[i]) + 1;
//                 int ei = i;
                
//                 for(int j = si + 1; j <= ei; ++j){
//                     int left = pre[j - 1];
//                     if(si != 0) left ^= pre[si - 1];
                    
//                     int right = pre[ei] ^ pre[j - 1];
                    
//                     if(left == right) count++;
//                 }
//             }
//             else xor.put(pre[i], i);
//         }
        
        return count;
    }
}