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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
    }
}

class BST {
    
    Node root;
    
    private Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        
        if(value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);
            
        return root;
    }
    
    public void insert(int value){
        root = insert(root, value);
    }
    
    private int searchGreater(Node root, int value){
        if(root == null)
            return -1;
            
        if(root.data <= value)
            return searchGreater(root.right, value);
            
        int leftAns = searchGreater(root.left, value);
        return (leftAns == -1) ? root.data : leftAns;
    }
    
    public int searchGreater(int value){
        return searchGreater(root, value);
    }
    
}
class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        BST bst = new BST();
        
        for(int i = n - 1; i >= 0; --i){
            list.add(bst.searchGreater(arr[i]));
            bst.insert(arr[i]);
        }
        
        Collections.reverse(list);
        return list;
    }
}
        
