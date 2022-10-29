//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String con[], String s)
    {
        Arrays.sort(con);
        ArrayList<String> contact= new ArrayList<>();
        for(String i: con){
            if(contact.size()==0 || (contact.size()!=0 && !contact.get(contact.size()-1).equals(i)))
                contact.add(i);
        }
        ArrayList<ArrayList<String>> ans= new ArrayList<>();
        for(int i=1; i<=s.length(); i++){
            String x= s.substring(0,i);
            ArrayList<String> list= new ArrayList<>();
            for(String st: contact){
                if(st.startsWith(x)){
                    list.add(st);
                }
            }
            if(list.size()==0)
                list.add("0");
            ans.add(list);
            contact= list;
        }
        return ans;
    }
}