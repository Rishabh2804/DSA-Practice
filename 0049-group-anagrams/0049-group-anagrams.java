class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();
        
        for(String str : strs){
            
            char[] alpha = new char[26];
            
            for(int i = 0; i < str.length(); ++i)
                alpha[str.charAt(i) - 'a']++;
            
            String anagramKey = String.valueOf(alpha);
            
            List<String> anagramGroup = dict.getOrDefault(anagramKey, new ArrayList<>());
            anagramGroup.add(str);
            
            dict.put(anagramKey, anagramGroup);
        }
        
        List<List<String>> anagramGroups = new ArrayList<>();
        for(String anagrams : dict.keySet())
            anagramGroups.add(dict.get(anagrams));
        
        return anagramGroups;
    }
}