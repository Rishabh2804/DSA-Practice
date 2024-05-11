class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {        
        int n = arr.length;
        
        PriorityQueue<int[]> fracs = new PriorityQueue<>((a, b) -> a[0] * b[1] - b[0] * a[1]);
        
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j) 
                fracs.add(new int[] {arr[i], arr[j]});
        }
        
        while(k --> 1) fracs.poll();
        
        return fracs.poll();
    }
}