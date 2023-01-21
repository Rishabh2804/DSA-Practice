//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minVal(int a, int b) {
        if (b == 0 || b == a)
            return b;

        List<Integer> bits = new ArrayList<>();

        int bitsB = 0;
        while (b > 0) {
            bitsB += b & 1;
            b >>= 1;
        }

        int bitsA = 0;
        while (a > 0) {
            bits.add(a & 1);
            bitsA += a & 1;
            a >>= 1;
        }

        int x = 0;
        if (bitsB <= bitsA) {
            for (int i = bits.size() - 1; i >= 0; --i) {
                x <<= 1;
                if (bits.get(i) == 0)
                    continue;
                else if (bitsB-- > 0)
                    x++;
            }
        } else {
            if (bitsB >= bits.size())
                return (1 << bitsB) - 1;

            bitsB -= bitsA;
            int zeroes = bits.size() - bitsA;

            for (int i = bits.size() - 1; i >= 0; --i) {
                x <<= 1;
                if (bits.get(i) == 1)
                    x++;
                else if (zeroes-- <= bitsB)
                    x++;
            }

            bitsB -= bits.size() - bitsA;
            while (bitsB-- > 0) {
                x <<= 1;
                x++;
            }
        }

        return x;
    }
}