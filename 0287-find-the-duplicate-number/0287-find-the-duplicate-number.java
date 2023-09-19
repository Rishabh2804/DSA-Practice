class Solution {    
    
    // T = O(n^2)
    // S = O(1)
    private int brute(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                if(nums[i] == nums[j]) return nums[i];
            }                
        }
        
        return -1; // will never reach here
    }
    
    // T = O(n)
    // S = O(n)
    private int countFind(int[] nums){
        int n = nums.length;
        int[] freq = new int[n];
        for(int i : nums){
            freq[i - 1]++;
            
            if(freq[i - 1] > 1) return i;
        }
        
        return -1; // will never reach here
    }
    
    // T = O(n)
    // S = O(1)
    private int tortoise(int[] nums){ // slow and fast pointer approach
        
        int slow = nums[0];
        int fast = nums[0];
        
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            // note: 
            // if slow gets stuck in a cycle, i.e. 
            // slow = nums[slow]
            // 
            // this actually means we have got our answer!
            //
            // explaination: 
            // since 0 is not present in array, 
            // we can reach ith index only by another index j
            // such that nums[j] == i
            // to make slow = nums[j] = i
            
            // if slow gets stuck, it means slow == nums[i] == nums[j]
            // which means same element is present at two indices, i and j
            // e.g.
            // S1 2 2 4
            // 1 S2 2 4
            // 1 2 S2 4
            // 1 2 S2 4 <-- stuck 
            // fast would already be here, as it was stuck before slow
            
            if(slow == fast) break;
        }
        
        // Now, in any case, a loop is not possible, 
        // since we are starting from index 0, 
        // an 0 is not present in array
        //
        // Thus, if we are able to get back to a previously visited index i, through nums[j]
        // this means there atleast 1 other index, say k, 
        // such that nums[j] == nums[k] == i
        
        // let slow be at j, fast at k
        // the traversal would be: 
        // j(S) --> i --> some series of moves --> k(F) --> i (cycle)
        // fast is bound to be stuck in a loop here, 
        // so we restart the journey of fast, and let slow continue
        // the next time slow and fast point at same element would be the answer
        
        fast = nums[0];
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];                        
        }
        
        return slow;
    }
    
    public int findDuplicate(int[] nums) {
        
        return tortoise(nums);
    }
}