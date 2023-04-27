class Solution {
    public int bulbSwitch(int n) {        
        int max = (int) Math.sqrt(n);        
        for(int i = 1; i*i <= n; ++i)
            System.out.println(i * i);
        
        return max;
    }
}