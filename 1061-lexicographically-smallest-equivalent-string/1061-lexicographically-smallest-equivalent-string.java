class Solution {
    static int[] parent = new int[26];
    static int[] dict = new int[26];
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
            dict[i] = i;
        }

        for (int i = 0; i < s1.length(); ++i) {
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';

            union(idx1, idx2);    
        }

        StringBuilder eqStr = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int idx = baseStr.charAt(i) - 'a';
            int par = find(idx);
 
            eqStr.append((char)(dict[par] + 'a'));
        }

        return eqStr.toString();
    }

    private void union(int x, int y) {
        int lexoFirst = Math.min(x, y);        
        int lexoSecond = Math.max(x, y);
        
        int par1 = find(lexoFirst);
        int par2 = find(lexoSecond);
        
        dict[par1] = Math.min(dict[par1], dict[par2]);
        
        parent[par2] = find(par1);        
    }

    private int find(int x) {
        if(x == parent[x])
            return x;
        
        return find(parent[x]);
    }
}