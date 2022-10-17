class Solution {
    
    // bits of pangram is a bitmask of chain of 1s of length 26
    int pangram = (1 << 26) - 1;
    
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
        
        int hash = 0;
        for(int i = 0; i < sentence.length(); ++i){
            hash |= 1 << (sentence.charAt(i) - 'a');
            // System.out.println(toBits(hash));
        }
                   
        // System.out.println(toBits(pangram));
        return hash == pangram;
    }
    
    // for visualizing bits in testing
    public List<Integer> toBits(int n){
        List<Integer> bits = new ArrayList();
        while(n > 0){
            bits.add(n & 1);
            n >>= 1;
        }
        
        while(bits.size() < 26)
            bits.add(0);
        
        Collections.reverse(bits);
        return bits;
    }
}