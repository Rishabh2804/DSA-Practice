class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> dset = new HashSet<>();
        dset.add(0);
        map.put(0,dset);

        for(int stone : stones){
            if(!map.containsKey(stone)) continue;
            HashSet<Integer> set = map.get(stone);
            
            for(int num : set){
                for(int i = -1; i <= 1; i++){
                    int next = num + i + stone;
                    if(stone < next && next <= stones[stones.length-1]){
                        HashSet<Integer> nset = map.getOrDefault(next, new HashSet<>());
                        nset.add(next - stone);
                        map.put(next, nset);
                    }
                }
            }
        }

        return map.containsKey(stones[stones.length-1]);
    }
}