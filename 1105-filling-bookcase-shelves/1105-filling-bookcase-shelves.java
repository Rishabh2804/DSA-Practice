class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize dp array to max value
        dp[0] = 0;  // Base case: no books require 0 height
        
        // Iterate through each book position
        for (int i = 1; i <= n; ++i) {
            int total_width = 0;
            int max_height = 0;
            // Try placing books from position j to i on the same shelf
            for (int j = i; j > 0; --j) {
                total_width += books[j-1][0];
                if (total_width > shelfWidth) {
                    break; // Shelf width exceeded
                }
                max_height = Math.max(max_height, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + max_height); // Update minimum height
            }
        }
        
        return dp[n]; // Return the minimum height for all books
    }
}