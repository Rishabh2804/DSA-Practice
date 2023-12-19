class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int n = img.length;
        int m = img[0].length;
        
        int[][] smoothImage = new int[n][m];
        
        for(int i = 0; i < n; ++i){
            
            for(int j = 0; j < m; ++j){
                int sum = 0;
                int count = 0;
                
                for(int x = i - 1; x <= i + 1; ++x){
                    if(x < 0 || x >= n) continue;
                    
                    for(int y = j - 1; y <= j + 1; ++y){
                        if(y < 0 || y >= m) continue;
                        
                        count++;
                        sum += img[x][y];
                    }
                }
                
                smoothImage[i][j] = sum / count;
            }
        }
        
        return smoothImage;
    }
}