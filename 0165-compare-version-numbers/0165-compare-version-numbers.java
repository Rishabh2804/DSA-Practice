class Solution {
    private void print(Object[] arr){
        for(Object obj : arr){
            System.out.print(obj + " ");
        }
        
        System.out.println();
    }
    
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        
        int maxLen = Math.max(v1.length, v2.length);
        
        int[] ver1 = new int[maxLen];
        int[] ver2 = new int[maxLen];
        
        for(int i = 0; i < v1.length; ++i) ver1[i] = Integer.parseInt(v1[i]);
        for(int i = 0; i < v2.length; ++i) ver2[i] = Integer.parseInt(v2[i]);
        
        for(int i = 0; i < maxLen; ++i){
            if(ver1[i] < ver2[i]) return -1;
            else if(ver1[i] > ver2[i]) return 1;                
        }
        
        return 0;
    }
}