class Solution {
    public int search(int[] nums, int target) {
        return bs(nums,target,0, nums.length-1);
    }
    public int bs(int[] n, int t,int s,int e){
        if(s>e){
            return -1;
        }
        int mid = (e+s)/2;
        if(n[mid]==t){
            return mid;
        }
        if(n[mid]>t){
            return bs(n, t, s, mid-1);
        }
        return bs(n, t, mid+1, e);
    }
}