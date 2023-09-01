class Solution {
    
    private int[] morph(String s){
        int[] arr = new int[s.length()];
        int id = 1;
        int[] ids = new int[256];
        for(int i = 0; i < s.length(); ++i){
            int idx = s.charAt(i) - '\0';
            if(ids[idx] == 0)
                ids[idx] = id++;
            
            arr[i] = ids[idx];
        }
        
        return arr;
    }
    
    private boolean isIdentical(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length) return false;
        
        for(int i = 0; i < arr1.length; ++i){
            if(arr1[i] != arr2[i])
                return false;
        }
        
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {        
        return isIdentical(morph(s), morph(t));        
    }    
}