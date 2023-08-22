class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder title = new StringBuilder();
        while(columnNumber > 0){
            columnNumber --;
            int curr = columnNumber % 26;
            title.append((char)('A' + curr));
            
            columnNumber /= 26;
        }
        
        title.reverse();
        return title.toString();
    }
}