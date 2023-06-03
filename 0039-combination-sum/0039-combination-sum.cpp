class Solution {
public:
    vector<vector<int>> solve(vector<int>& candidates,int idx, int target)
    {
        if(idx >= candidates.size()) {
            if(target == 0 )
                return {{}};
            else
                return {};
        }
        
        vector<vector<int>> ans;
        
          int i = 0;
        while(candidates[idx]*i <= target)
        {
            int remtarget = target - candidates[idx]*i ;
            vector<vector<int>> remans = solve(candidates , idx+1 , remtarget);
            for(auto &it : remans)
            {
                for(int j = 0 ; j<i ; j++)
                {
                   it.push_back(candidates[idx]);
                }
            }
            
            for(auto &it : remans)
            {
                ans.push_back(it);
                
            }
            
            i++;
        }
        
        return ans;
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        return solve(candidates , 0 , target);
    }
};