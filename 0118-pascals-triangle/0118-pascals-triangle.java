class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<>();
        
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        triangle.add(prevRow);
        
        numRows--;
        while(numRows --> 0){
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            
            for(int i = 1; i < prevRow.size(); ++i)
                currRow.add(prevRow.get(i) + prevRow.get(i - 1));

            currRow.add(1);

            triangle.add(currRow);
            prevRow = currRow;
        }
        
        return triangle;
    }
}