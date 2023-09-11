class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> groupTypes = new HashMap<>();
        for(int i = 0; i < groupSizes.length; ++i){
            List<Integer> currType = groupTypes.getOrDefault(groupSizes[i], new ArrayList<>());
            currType.add(i);
            groupTypes.put(groupSizes[i], currType);
        }
        
        List<List<Integer>> groups = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> groupType : groupTypes.entrySet()){
            int len = groupType.getKey();
            List<Integer> allPeople = groupType.getValue();
            
            List<Integer> group = new ArrayList<>();
            for(int person : allPeople){
                group.add(person);
                if(group.size() == len){
                    groups.add(group);
                    group = new ArrayList<>();
                }
            }
        }
        
        return groups;
    }
}