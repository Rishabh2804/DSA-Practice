class Solution {
    
    static final int NONE = -1;
    public int majorityElement(int[] nums) {
        
        int major = NONE;
        int majorityCount = 0;
        
        for(int i : nums){
            if(major == NONE){
                major = i;
                majorityCount ++;
            } else if(i != major){
                majorityCount --;
                if(majorityCount == 0)
                    major = NONE;
            } else majorityCount++;
        }
        
        return major;
    }
}