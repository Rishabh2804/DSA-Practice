//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] lexicographicallyLargest(int[] arr, int n) {

        int parity = arr[0] % 2;

        int si = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != parity) {
                quickSort(si, i - 1, arr);
                si = i;
                parity = arr[i] % 2;
            }
        }

        quickSort(si, n - 1, arr);
        return arr;
    }

    public void quickSort(int si, int ei, int[] arr) {
        if (si >= ei)
            return;

        int pivotIndex = partition(si, ei, arr);
        quickSort(si, pivotIndex - 1, arr);
        quickSort(pivotIndex + 1, ei, arr);
    }

    public int partition(int si, int ei, int[] arr) {
        int mid = (si + ei) / 2;
        int pivot = arr[mid];
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (arr[i] > pivot)
                count++;
        }

        int pivotIndex = si + count;
        arr[mid] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        int i = si, j = ei;
        while (i < pivotIndex) {
            if (arr[i] <= pivot) {
                while (j > pivotIndex && arr[j] <= pivot)
                    j--;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else
                i++;
        }

        return pivotIndex;
    }
}