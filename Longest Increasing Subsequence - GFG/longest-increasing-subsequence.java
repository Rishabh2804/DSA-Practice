//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

class Solution 
{
    //Function to find length of longest increasing subsequence.
    
    static int lowerBound(List<Integer> list, int x){
        int si = 0, ei = list.size() - 1;
        while(si < ei){
            int mid = (si + ei) / 2;
            if(list.get(mid) >= x)
                ei = mid;
            else 
                si = mid + 1;
        }
        
        return si;
    }
    
    static int longestSubsequence(int size, int a[])
    {
        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(a[0]);
        
        for(int i = 1; i < size; ++i){
            if(a[i] > subsequence.get(subsequence.size() - 1))
                subsequence.add(a[i]);
            else{
                int idx = lowerBound(subsequence, a[i]);
                subsequence.set(idx, a[i]);
            }
        }
        
        // System.out.println(subsequence);
        return subsequence.size();
    }
} 