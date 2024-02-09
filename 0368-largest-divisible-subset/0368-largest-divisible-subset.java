class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);        
        
        int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        
        ArrayList<ArrayList<Integer>> allSets = new ArrayList<>();
        
        int maxLen = 1;
        int longestSetIdx = 0;
        
        for(int i = 0; i < n; ++i){            
            int currLen = 1;
            int idx = -1;
            for(int j = i - 1; j >= 0; --j){
                if(nums[i] % nums[j] == 0){
                    
                    int preLen = 1 + allSets.get(j).size();
                    if(preLen > currLen){
                        currLen = preLen;
                        idx = j;
                    }
                }
            }
            
            ArrayList<Integer> currList;
            if(idx == -1)
                currList = new ArrayList<>();
            else
                currList = new ArrayList<>(allSets.get(idx));
            
            currList.add(nums[i]); 
            
            if(currList.size() > maxLen){
                maxLen = currList.size();
                longestSetIdx = i;
            }
            
            allSets.add(currList);
        }
        
        return allSets.get(longestSetIdx);                
    }
}