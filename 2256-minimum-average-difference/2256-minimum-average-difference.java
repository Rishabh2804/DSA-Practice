class Solution {
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1)
            return 0;

        int n = nums.length;
        long[] sum = new long[nums.length + 1];
        // sum[0] = nums[0];
        for (int i = 1; i <= nums.length; ++i)
            sum[i] += sum[i - 1] + nums[i - 1];

        long min = Long.MAX_VALUE;
        int minI = -1;
        for (int i = 0; i < n; i++) {
            long curr = -1L;
            if (i == n - 1)
                curr = sum[n] / n;
            else
                curr = Math.abs(((sum[i + 1] / (i + 1)) - ((sum[n] - sum[i + 1]) / (n - i - 1))));

            if (min == -1) {
                min = curr;
                minI = i;
            } else if (curr < min) {
                min = curr;
                minI = i;
            }
        }

        return minI;
    }
}