class Solution {
    public int maximum69Number (int num) {
        
        ArrayList<Integer> digits = new ArrayList<>();
        while(num != 0){
            digits.add(num % 10);
            num /= 10;
        }
        
        Collections.reverse(digits);
        
        int ans = 0;
        for(int i = 0; i < digits.size(); ++i){            
            if(digits.get(i) == 6){
                digits.set(i, 9);
                break;
            }
        }
        
        for(int i : digits)
            ans = ans * 10 + i;
        
        return ans;
    }
}