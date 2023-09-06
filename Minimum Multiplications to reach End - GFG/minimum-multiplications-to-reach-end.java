//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static final int MOD = 100000;
    static final int SIZE = MOD;
    static boolean[] vis = new boolean[SIZE];
    
    static final int NUM = 0;
    static final int OPS = 1;
    
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start % 2 == 0 && end % 2 == 1)
            return -1;
            
        Arrays.fill(vis, false);
        
        vis[start] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        
        int ops = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size --> 0){
                int curr = q.poll();
                
                if(curr == end) return ops;
                
                for(int i : arr){
                    int next = (i * curr) % MOD;
                    if(!vis[next]){
                        vis[next] = true;
                        q.add(next);
                    }
                }
            }
            
            ops++;
        }
        
        return -1;
    }
}
