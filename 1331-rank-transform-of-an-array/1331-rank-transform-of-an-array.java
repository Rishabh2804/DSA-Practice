class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] arr1 = new int[arr.length];
        for(int i = 0; i < arr.length; ++i)
            arr1[i] = arr[i];
        
        HashMap<Integer, Integer> rank = new HashMap<>();
        Arrays.sort(arr1);
        
        for(int i : arr1){
            if (rank.get(i) == null)
                rank.put(i, rank.size() + 1);
        }
        
        for(int i = 0; i < arr.length; ++i)
            arr[i] = rank.get(arr[i]);
        
        return arr;
    }
}