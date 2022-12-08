//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    
    static boolean[] isPrime;
    static int[] primeCount;
    
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        long max = 0;
        for(long n : query)
            max = Math.max(max, n);
            
        getPrimes((int)Math.sqrt(max));
        
        ArrayList<Integer> res = new ArrayList<>();
        for(long n : query)
            res.add(primeCount[(int)Math.sqrt(n)]);
            
        return res;
    }
    
    static void getPrimes(int n){
        
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        
        primeCount = new int[n + 1];
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i = 2; i <= n; ++i){
            if(!isPrime[i]){
                primeCount[i] = primeCount[i - 1];
                continue;
            }
            
            primeCount[i] = 1 + primeCount[i - 1];
            
            int j = 2;
            while(i * j <= n) {
                isPrime[i * j] = false;
                j++;
            }
        }
        
    }
}