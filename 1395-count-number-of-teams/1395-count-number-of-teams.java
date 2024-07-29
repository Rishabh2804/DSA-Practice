class Solution {
    
    private int[][] find(int i, int[] arr){
        
        int curr = arr[i];
        
        int s1 = 0;
        int s2 = 0;
        int g1 = 0;
        int g2 = 0;
        
        for(int j = 0; j < i; ++j){
            if(arr[j] < curr) s1++;
            else if(arr[j] > curr) g1++;
        }
        
        for(int j = i + 1; j < arr.length; ++j){
            if(arr[j] < curr) s2++;
            else if(arr[j] > curr) g2++;
        }
        
        return new int[][]{
            {s1, g1}, {s2, g2}
        };
    }
    
    public int numTeams(int[] rating) {
        
        int count = 0;
        for(int i = 0; i < rating.length; ++i){
            int[][] res = find(i, rating);
            
            count += (res[0][0] * res[1][1]) + (res[0][1] * res[1][0]);
        }
        
        return count;
    }
}