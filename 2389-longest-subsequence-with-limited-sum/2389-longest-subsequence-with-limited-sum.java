class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);
        
        int[] prefix = new int[nums.length];
        
        prefix[0] = nums[0];        
        for(int i = 1; i < nums.length; ++i)
            prefix[i] = nums[i] + prefix[i - 1];
        
        int[] ans = new int[queries.length];
        for(int q = 0; q < queries.length; ++q)
            ans[q] = ub(queries[q], prefix);
        
        return ans;
    }
    
    public int ub(int x, int[] arr){
        
        int si = 0, ei = arr.length - 1;
        while(si < ei){
            int mid = 1 + (si + ei) / 2;
            
            if(arr[mid] <= x)
                si = mid;
            else
                ei = mid - 1;            
        }
        
        if(arr[si] <= x)
            si++;
        
        return si;
    }
}