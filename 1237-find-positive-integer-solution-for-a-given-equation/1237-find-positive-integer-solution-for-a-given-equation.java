/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    List<List<Integer>> pairs;
    
    private void add(int x, int y){
        List<Integer> pair = new ArrayList<>();
        pair.add(x);
        pair.add(y);
        
        pairs.add(pair);
    }
    
    private void solve(int xsi, int xei, int ysi, int yei, int z, CustomFunction cf){
        if(xsi > xei || ysi > yei) return;
        
        if(xsi == xei){            
            while(ysi <= yei){
                int ymid = (ysi + yei) / 2;
                int ans = cf.f(xsi, ymid);
                
                if(ans == z){
                    add(xsi, ymid);
                    return;
                } 
                else if(ans < z) ysi = ymid + 1;
                else yei = ymid - 1;                    
            }
            
            return;
        } else if(ysi == yei){
            while(xsi <= xei){
                int xmid = (xsi + xei) / 2;
                int ans = cf.f(xmid, ysi);
                
                if(ans == z){
                    add(xmid, ysi);
                    return;
                } 
                else if(ans < z) xsi = xmid + 1;
                else xei = xmid - 1;                    
            }
            
            return;
        }
        
        int xmid = (xsi + xei + 1) / 2;
        int ymid = (ysi + yei + 1) / 2;
        
        int ans = cf.f(xmid, ymid);

        if(ans == z) {             
            // Quadrant I would contain all values > z
            // Quadrant III would contain all values < z
            
            add(xmid, ymid);
            
            solve(xsi, xmid - 1, ymid, yei, z, cf); // Quad II
            solve(xmid, xei, ysi, ymid - 1, z, cf); // Quad IV
        } else if(ans < z) {
            // Quadrant III would contain all values < z
            
            solve(xmid, xei, ymid, yei, z, cf); // Quad I
            solve(xsi, xmid - 1, ymid, yei, z, cf); // Quad II
            solve(xmid, xei, ysi, ymid - 1, z, cf); // Quad IV            
        } else {
            // Quadrant I would contain all values > z
            
            solve(xsi, xmid - 1, ymid, yei, z, cf); // Quad II
            solve(xsi, xmid - 1, ysi, ymid - 1, z, cf); // Quad III
            solve(xmid, xei, ysi, ymid - 1, z, cf); // Quad IV            
        }        
    }
    
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        pairs = new ArrayList<>();
        // System.out.println(customfunction.f(500, 500));
        
        solve(1, 1000, 1, 1000, z, customfunction);
        return pairs;
    }
}