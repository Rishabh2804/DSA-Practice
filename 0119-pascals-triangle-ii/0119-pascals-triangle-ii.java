class Solution {
    
    static final void pascalise(ArrayList<Integer> row){
        row.add(0);
        for(int i = row.size() - 1; i > 0; --i)
            row.set(i, row.get(i) + row.get(i - 1));
    }
    
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        
        if(rowIndex == 0) return row;
        
        while(rowIndex --> 0){
            pascalise(row);
        }
        
        return row;
    }
}