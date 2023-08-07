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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
        public static int countFractions(int n, int[] numerator, int[] denominator) {

        long[][] fracts = new long[n][3];
        for (int i = 0; i < n; ++i) {
            fracts[i][0] = numerator[i];
            fracts[i][1] = denominator[i];
            fracts[i][2] = 1;
        }

        Arrays.sort(fracts, (a, b) -> {
            long diff1 = a[0] * b[1];
            long diff2 = a[1] * b[0];
            if(diff1 < diff2)
                return -1;
            else if(diff1 == diff2)
                return 0;
            return 1;
        });

        ArrayList<long[]> distFract = new ArrayList<>();
        int si = 0;
        int ei = 0;
        distFract.add(fracts[0]);

        for (; ei < n; ++ei) {
            if (fracts[ei][0] * fracts[si][1] != fracts[ei][1] * fracts[si][0]) {
                fracts[si][2] = ei - si;
                distFract.add(fracts[ei]);  
                si = ei;
            } 
        }

        // for(int[] f : distFract){
        //     System.out.println(f[0] + " " + f[1] + " " + f[2]);
        // }
        
        int count = 0;
        si = 0;
        ei = distFract.size() - 1;
        while (si <= ei) {
            long[] fract1 = distFract.get(si);
            long[] fract2 = distFract.get(ei);

            if(2 * fract1[0] == fract1[1]){
                count += (fract1[2] * (fract1[2] - 1)) / 2;
                si++;
                continue;
            } else if(2 * fract2[0] == fract2[1]){
                count += (fract2[2] * (fract2[2] - 1)) / 2;
                ei--;
                continue;
            }
            
            long num = fract1[0] * fract2[1] + fract1[1] * fract2[0];
            long den = fract1[1] * fract2[1];
            long diff = num - den;

            if (diff < 0)
                si++;
            else if (diff > 0)
                ei--;
            else {
                count += fract1[2] * fract2[2];
                si++;
                ei--;
            }
        }

        return count;
    }

}
        
