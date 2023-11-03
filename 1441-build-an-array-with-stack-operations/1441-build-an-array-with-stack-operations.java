class Solution {
    
    static final String PUSH = "Push";
    static final String POP = "Pop";
    
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        
        int i = 0;
        int j = 1;
        while(i < target.length && j <= n){
            operations.add(PUSH);
            
            if(target[i] == j) i++;
            else operations.add(POP);                

            j++;
        }
        
        return operations;
    }
}