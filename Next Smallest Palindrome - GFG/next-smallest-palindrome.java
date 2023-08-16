//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int nums[], int n) {
        boolean flag = true;
        for(int i = 0; i < n / 2; ++i){
            int left = i;
            int right = n - i - 1;
            
            if(nums[left] == nums[right]) continue;
            
            flag = nums[left] < nums[right];
            nums[right] = nums[left];
        }
        
        if(flag){
            for(int i = n / 2; i < n; ++i){
                if(nums[i] == 9){
                    nums[i] = 0;
                    nums[n - i - 1] = 0;
                } else{
                    nums[i]++;
                    if(2 * i != n - 1)
                        nums[n - i - 1]++;
                    
                    flag = false;
                    break;
                }
            }
        }
        
        Vector<Integer> nextPal = new Vector<>();
        for(int i : nums)
            nextPal.add(i);
        
        if(flag) {
            nextPal.set(0, 1);
            nextPal.add(1);
        }
        
        return nextPal;
    }
}