/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    static interface SlopeComparator{        
        int compare(int a, int b);
    }            
    
    static final SlopeComparator upwardSlope = (a, b) -> a - b;
    static final SlopeComparator downwardSlope = (a, b) -> b - a;
    
    private int binarySearch(int si, int ei, MountainArray mountainArr, int target, SlopeComparator cmp){
        while(si <= ei){
            int mid = (si + ei) / 2;
            
            int midEle = mountainArr.get(mid);
            
            if(cmp.compare(midEle, target) == 0) 
                return mid;
            else if(cmp.compare(midEle, target) < 0)
                si = mid + 1;
            else
                ei = mid - 1;
        }        
        
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        
        int si = 1, ei = len - 1;
        while(si < ei){
            
            int mid = (si + ei) / 2;
            
            int preMidEle = mountainArr.get(mid - 1);
            int midEle = mountainArr.get(mid);
            int postMidEle = mountainArr.get(mid + 1);
            
            if(preMidEle < midEle && midEle < postMidEle) // upward slope
                si = mid + 1;
            else if(preMidEle > midEle && midEle > postMidEle) // downward slope
                ei = mid - 1;
            else // only one condition is possible now, i.e., preMidEle < midEle && midEle > postMidEle
                ei = mid; // requirement is to find minimum index --> lowerbound
        }
        
        int pivotIndex = si;
        
        int idx = binarySearch(0, si, mountainArr, target, upwardSlope);
        if(idx != -1) return idx;
        
        return binarySearch(si, len - 1, mountainArr, target, downwardSlope);
    }
}