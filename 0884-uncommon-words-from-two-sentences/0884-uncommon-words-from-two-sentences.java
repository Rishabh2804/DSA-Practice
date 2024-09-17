class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> set1 = new HashMap<>();
        String[] tokens1 = s1.split(" ");
        for(String word : tokens1){
            set1.putIfAbsent(word, 0);
            set1.put(word, set1.get(word) + 1);
        }
        
        
        HashMap<String, Integer> set2 = new HashMap<>();
        String[] tokens2 = s2.split(" ");
        for(String word : tokens2){
            set2.putIfAbsent(word, 0);
            set2.put(word, set2.get(word) + 1);
        }
        
        ArrayList<String> temp = new ArrayList<>();
        for(String word : set1.keySet()){
            if(set1.get(word) == 1 && !set2.containsKey(word)) 
                temp.add(word);
        }
        
        for(String word : set2.keySet()){
            if(set2.get(word) == 1 && !set1.containsKey(word)) 
                temp.add(word);
        }
        
        String[] res = new String[temp.size()];
        for(int i = 0; i < temp.size(); ++i)
            res[i] = temp.get(i);
        
        return res;
    }
}