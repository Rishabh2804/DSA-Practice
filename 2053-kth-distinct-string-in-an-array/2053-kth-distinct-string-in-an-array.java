class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        HashMap<String, Integer> set = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(String str : arr){
            if(!set.containsKey(str)) list.add(str);
            
            set.putIfAbsent(str, 0);
            set.put(str, set.get(str) + 1);
        }
        
        int i = 0;
        for(String str : list){
            if(set.get(str) == 1) i++;
            if(i == k) return str;
        }
        return "";
    }
}