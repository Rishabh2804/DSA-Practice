class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int[] parent = new int[26];
        int[] dict = new int[26];

        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
            dict[i] = i;
        }

        for (int i = 0; i < s1.length(); ++i) {
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';

            union(idx1, idx2, dict, parent);    
        }

        for(int i : dict)
            System.out.print((char)(i + 'a') + " ");
        System.out.println();
        for(int i = 0; i < 26; ++i)
            System.out.print((char)(find(i, parent) + 'a') + " ");
        System.out.println();

        StringBuilder eqStr = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int idx = baseStr.charAt(i) - 'a';
            int par = find(idx, parent);
 
            eqStr.append((char)(dict[par] + 'a'));
        }

        return eqStr.toString();
    }

    private void union(int x, int y, int[] dict, int[] parent) {
        int par1 = find(x, parent);
        int par2 = find(y, parent);
        
        int lexoFirst = Math.min(x, y);        
        dict[par1] = Math.min(dict[par1], lexoFirst);    
        dict[par1] = Math.min(dict[par1], dict[par2]);
        
        parent[find(y, parent)] = find(x, parent);
    }

    private int find(int x, int[] parent) {
        if(x == parent[x])
            return x;
        
        return find(parent[x], parent);
    }
}