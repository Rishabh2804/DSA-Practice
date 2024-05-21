class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    public List<List<Integer>> helper(int[] nums, int i) {
        if (i == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> sub = new ArrayList<>();
            ans.add(sub);
            return ans;
        }
        List<List<Integer>> smallans = helper(nums, i + 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < smallans.size(); r++) {
            List<Integer> a1 = smallans.get(r);
            ans.add(a1);
            List<Integer> a2 = new ArrayList<>();
            a2.add(nums[i]);
            for (int k : a1)
                a2.add(k);
            ans.add(a2);
        }
        return ans;
    }
}