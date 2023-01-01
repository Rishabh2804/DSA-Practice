class Solution {
    public boolean wordPattern(String pattern, String s) {
        return isIdentical(hashByChar(pattern), hashByWord(s));
    }
    
    public int[] hashByWord(String pattern){
        
        String[] words = pattern.split(" ");
        int[] hashed = new int[words.length];
        
        int id = 1;
        HashMap<String, Integer> hashes = new HashMap<>();
        
        int k = 0;
        for(String word : words){
            if(!hashes.containsKey(word))                
                hashes.put(word, id++);            
            
            hashed[k++] = hashes.get(word);
        }
        
        return hashed;
    }
    
    public int[] hashByChar(String pattern){
                
        int[] hashed = new int[pattern.length()];
        
        int id = 1;
        HashMap<Character, Integer> hashes = new HashMap<>();
        
        int k = 0;
        for(int i = 0; i < pattern.length(); ++i){
            if(!hashes.containsKey(pattern.charAt(i)))                
                hashes.put(pattern.charAt(i), id++);            
            
            hashed[k++] = hashes.get(pattern.charAt(i));
        }
        
        return hashed;
    }
    
    public boolean isIdentical(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length)
            return false;
        
        for(int i = 0; i < arr1.length; ++i){
            if(arr1[i] != arr2[i])
                return false;
        }
        
        return true;
    }
}