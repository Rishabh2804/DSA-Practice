class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int nge = -1;
        while(n > 0){
            int currDigit = n % 10;
            n /= 10;                        

            if(!digits.isEmpty() && currDigit < digits.get(digits.size() - 1)){
                nge = currDigit;
                break;
            }
            
            digits.add(currDigit);            
        }
        
        if(nge == -1) return -1;
        
        System.out.println("\n" + n + " " + nge + " " + digits);
        
        int j = 0;
        while(j < digits.size()){
            if(digits.get(j) > nge){
                int temp = digits.get(j);
                digits.set(j, nge);
                nge = temp;
                
                break;
            }
            
            j++;
        }
        
        System.out.println(n + " " + nge + " " + digits + "\n");
        
        Collections.sort(digits);

        n = n * 10 + nge;
        for(int digit : digits){
            long temp = n * 10L + digit;
            if(temp > Integer.MAX_VALUE) return -1;
            
            n = (int)temp;
        }
        
        return n;
    }
}