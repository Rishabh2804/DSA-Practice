class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Boolean[] reg = new Boolean[1001];
        // Arrays.fill(reg, -1000);
        
        for(int i : nums1) reg[i] = false;
        
        int tCount = 0;
        for(int i : nums2) {
            if(reg[i] != null) reg[i] = true;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <= 1000; ++i){        
            if(reg[i] != null && reg[i]) list.add(i);
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i)
            res[i] = list.get(i);
        
        return res;
    }
}