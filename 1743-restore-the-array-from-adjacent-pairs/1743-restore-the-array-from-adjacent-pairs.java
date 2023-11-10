class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int count=0,x,y;
        LinkedHashSet<Integer> arr = new LinkedHashSet<>();
        HashMap<Integer, List<Integer>> pairs=new HashMap<>();
        for(int i=0;i<adjacentPairs.length;i++){
            arr.add(adjacentPairs[i][1]);
            arr.add(adjacentPairs[i][0]);
            pairs.computeIfAbsent(adjacentPairs[i][1], k -> new ArrayList<>()).add(adjacentPairs[i][0]);
            pairs.computeIfAbsent(adjacentPairs[i][0], k -> new ArrayList<>()).add(adjacentPairs[i][1]);
        }
        System.out.println(pairs);
        int val=0;
        for(Map.Entry<Integer, List<Integer>> entry: pairs.entrySet()){
            
            if(entry.getValue().size()==1){
                val=entry.getKey();
                break;
            }
        }
        int []arr1 = new int[arr.size()];
        list_array(pairs, arr, val, arr1, 0);
        return arr1;
    }
    public void list_array(HashMap<Integer, List<Integer>> pairs, LinkedHashSet<Integer> arr, int val, int[] arr1, int j) {
        if(arr.size()>0){
            for(int i:pairs.get(val)){
                if(arr.contains(i)){
                    arr1[j] = val;
                    arr.remove(val);
                    if(arr.size()==1){
                        arr1[j+1] = i;
                    }
                    list_array(pairs, arr, i, arr1, j+1);
                }
            }
        }
    }
}