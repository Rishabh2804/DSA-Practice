class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();
        
        for(String str : strs){
            
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            
            List<String> anagramGroup = 
                dict.getOrDefault(sortedStr, new ArrayList<>());
            
            anagramGroup.add(str);
            dict.put(sortedStr, anagramGroup);
        }
        
        List<List<String>> anagramGroups = new ArrayList<>();
        for(String anagrams : dict.keySet())
            anagramGroups.add(dict.get(anagrams));
        
        return anagramGroups;
    }
}