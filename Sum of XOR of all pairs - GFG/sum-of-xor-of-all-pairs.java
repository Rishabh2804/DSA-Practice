//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    long res = obj.sumXOR(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
   
   //     
   //  Sum of pairs = Σ  Σ     (a[i] ^ a[j])
   //                i=1 j=i+1    
   //
   //  -> Determining the result for kth bit: 
   //     Let n be size of array
   //
   //     Let x be count of elements with kth bit set, 
   //     and y be count of elements with kth bit unset = n - x
   //    
   //     1 1 1 1 ... x times    0 0 0 0 ... y times
   //
   //     Taking one element from set bits, XORed with any element 
   //     from unset bits would give 1, i.e., y times.
   //
   //     This would happen x times
   //
   //     Hence, S(k) = xy = Set(k) * Unset(k)
   //     Total sum = Σ (1 << k) * S(k)
   
    static final int[] bitReg = new int[32];
    
    private void addBits(int n){
        int bitPos = 0;
        while(n != 0){
            bitReg[bitPos] += n & 1;
            bitPos++;
            n >>= 1;
        }
    }
    
    private long getSum(int n){
        long sum = 0;
        for(int k = 0; k < bitReg.length; ++k)
            sum += 1l * (1 << k) * bitReg[k] * (n - bitReg[k]);
        
        return sum;
    }
    
    public long sumXOR (int arr[], int n) {
        Arrays.fill(bitReg, 0);
        
        for(int ele : arr)
            addBits(ele);
            
        return getSum(n);
    }
    
    
}


