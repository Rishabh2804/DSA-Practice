class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        ArrayList<double[]> tower = new ArrayList<>();
        for(int i = 0; i <= query_row; ++i)
            tower.add(new double[i + 1]);  
        
        tower.get(0)[0] = poured;
        
        for(int i = 0; i < tower.size(); ++i){            
            double[] row = tower.get(i);
            for(int j = 0; j < row.length; ++j){
                double extra = row[j] - 1;
                row[j] = Math.min(row[j], 1);
                
                System.out.print(row[j] + " ");

                if(extra <= 0 || i == query_row) continue;

                double share = extra / 2.0f;
                tower.get(i + 1)[j] += share;
                tower.get(i + 1)[j + 1] += share;                
            }
            
            System.out.println();
        }
        
        System.out.println();

        return tower.get(query_row)[query_glass];
    }
}