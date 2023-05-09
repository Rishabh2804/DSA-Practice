class Solution {
    
    static final int[] xDir = {1, 0, -1, 0};
    static final int[] yDir = {0, 1, 0, -1};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int currDir = 0;
        int i = 0, j = 0;
        
        while(res.size() < n * m){
            res.add(matrix[i][j]);
            
            i += yDir[currDir];
            j += xDir[currDir];
            
            if(j > right){
                j = right;
                i++;
                top++;
                
                currDir = (currDir + 1) % 4;                                
            } else if(j < left){
                j = left;
                i--;
                bottom--;
                
                currDir = (currDir + 1) % 4;                                
            }
            
            if(i > bottom){
                i = bottom;
                j--;
                right--;
                
                currDir = (currDir + 1) % 4;                                
            } else if(i < top){
                i = top;
                j++;
                left++;
                
                currDir = (currDir + 1) % 4;                                
            }            
        }
        
        return res;
    }
}