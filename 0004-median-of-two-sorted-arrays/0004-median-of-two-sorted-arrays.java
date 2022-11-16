class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        
        int mid1 = (n + 1) / 2;
        double ans1 = getKth(0, nums1, 0, nums2, mid1);
        if(n % 2 == 0){
            int mid2 = mid1 + 1;            
            double ans2 = getKth(0, nums1, 0, nums2, mid2);
            return (ans1 + ans2) / 2;
        }
        else
            return ans1;
    }
    
    public double getKth(int i1, int[] nums1, int i2, int[] nums2, int k){
        if(i1 >= nums1.length)
            return nums2[i2 + k - 1];
        
        if(i2 >= nums2.length)
            return nums1[i1 + k - 1];
        
        if(k == 1)
            return Math.min(nums1[i1], nums2[i2]);
        
        int k1 = i1 + k / 2 - 1;
        int k2 = i2 + k / 2 - 1;
                
        int pivot1 = Integer.MAX_VALUE;
        if(k1 < nums1.length)
            pivot1 = nums1[k1];
        
        int pivot2 = Integer.MAX_VALUE;
        if(k2 < nums2.length)
            pivot2 = nums2[k2];
        
        if(pivot1 < pivot2)
            return getKth(k1 + 1, nums1, i2, nums2, k - k / 2);
        else
            return getKth(i1, nums1, k2 + 1, nums2, k - k / 2);
    }
}