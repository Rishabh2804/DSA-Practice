//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Pair{
        int negStart;
        int posStart;
        
        Pair(int negStart, int posStart){
            this.negStart = negStart;
            this.posStart = posStart;
        }
    }
    
    static int result;
    
    public static long bestNode(int N, int[] A, int[] P) {
        
        result = Integer.MIN_VALUE;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; ++i)
            adj.add(new ArrayList<>());
            
        for(int i = 0; i < N; ++i){
            if(P[i] == -1)
                continue;
                
            adj.get(P[i] - 1).add(i);
        }
        
        dfs(0, adj, A);
        
        return result;
    }
    
    public static Pair dfs(int root, List<List<Integer>> adj, int[] values){
        if(adj.get(root).size() == 0){
            result = Math.max(result, values[root]);
            return new Pair(0 - values[root], values[root]);
        }
        
        int negMax = Integer.MIN_VALUE;
        int posMax = Integer.MIN_VALUE;
        
        for(int child : adj.get(root)){
            Pair p = dfs(child, adj, values);
            
            negMax = Math.max(negMax, p.negStart);
            posMax = Math.max(posMax, p.posStart);
        }
        
        negMax += values[root];
        posMax -= values[root];
        
        result = Math.max(result, negMax);
        return new Pair(posMax, negMax);
    }
    
}
        
