class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        Integer[] indices = new Integer[heights.length];
        for(int i = 0; i < indices.length; ++i) indices[i] = i;
        
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        
        String[] sort = new String[names.length];
        for(int i = 0; i < names.length; ++i)
            sort[i] = names[indices[i]];
        
        return sort;
    }
}