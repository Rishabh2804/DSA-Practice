class Solution {
    
    private static final String[] Units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
    private static final String[] Tenths = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static final String[] Ranks = {"Hundred", "Thousand", "Million", "Billion"};
    
    private StringBuilder evalHundredths(int num){
        StringBuilder sb = new StringBuilder();
        
        if(num < 20) {            
            sb.append(Units[num]);
            return sb;
        }
        
        int[] dig = new int[3];
        
        if(num >= 100) {
            int hundredth = num / 100;
            num %= 100;
            
            sb.append(Units[hundredth])
              .append(" ")
              .append(Ranks[0])
              .append(" ");
        }
                
        if(num < 20) sb.append(Units[num]).append(" ");
        else {
            int tenth = num / 10;
            num %= 10;
            
            sb.append(Tenths[tenth])
              .append(" ");
            
            if(num > 0) sb.append(Units[num]).append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }
    
    private String trim(String str){
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0; i < str.length() - 1; ++i){
            if(str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') 
                continue;
            
            sb.append(str.charAt(i));
        }
        
        sb.append(str.charAt(str.length() - 1));
            
        if(sb.charAt(0) == ' ') sb.deleteCharAt(0);
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        int rank = 0;
        
        List<String> parts = new LinkedList<>();
        while(num > 0){
            int rem = num % 1000;
            num /= 1000;
            
            if(rem == 0) {
                rank++;
                continue;
            }
            
            StringBuilder res = evalHundredths(rem);            
            res.append(" ");
            
            if(rank > 0) res.append(Ranks[rank]).append(" ");
            rank++;            
            
            parts.add(res.toString());
        }
        
        Collections.reverse(parts);
        
        for(String str : parts) {    
            
            sb.append(str);
        }
        
        int last = sb.length() - 1;
        while(last >= 0 && sb.charAt(last) == ' ') {
            sb.deleteCharAt(last);
            last --;
        }
        
        
        return trim(sb.toString());
    }
}