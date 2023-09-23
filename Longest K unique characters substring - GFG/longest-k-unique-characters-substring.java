//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int ans =-1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1 && map.size() <= k) {
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == k) {
                    ans = Math.max(ans, i - j);
                }
                f1 = true;
            }

            // break hogya now lets release the first char
            while (j < i && map.size() != k) {
                j++;
                char ch = s.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
                f2 = true;

            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        
        return ans;
    }
}