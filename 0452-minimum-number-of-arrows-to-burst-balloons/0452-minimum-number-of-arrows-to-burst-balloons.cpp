class Solution {
public:
    
    static bool cmp(vector<int>& a, vector<int>& b){
        return a[1] < b[1];
    }
    
    int findMinArrowShots(vector<vector<int>>& points) {
        
        if(points.size() < 2)
            return points.size();
        
        sort(points.begin(), points.end(), cmp);
        int arrows = 1;
        int prev = points[0][1];
        for(int i = 1;i < points.size(); ++i){
            if(points[i][0] > prev){
                prev = points[i][1];
                arrows++;
            }                
        }
        
        return arrows;
    }
};