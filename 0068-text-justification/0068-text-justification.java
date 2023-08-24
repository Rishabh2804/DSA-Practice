class Solution {
    private List<String> solve(int i, String[] words, int maxWidth){
        if(i >= words.length) return new ArrayList();
        
        int remWidth = maxWidth - words[i].length();
        int j = i + 1;
        while(remWidth > 0 && j < words.length){
            if(remWidth < 1 + words[j].length()) break;
            
            // atleast 1 unit of extra space would be required for spacing
            remWidth -= 1 + words[j].length(); 
            j++;
        }
        
        // eot --> end of text
        boolean eot = j == words.length;
        j--;
        
        // wordCount = j - i + 1;
        // spaceSlots = wordCount - 1;                        
        int spaceSlots = j - i;            
        remWidth += spaceSlots; // 1 unit of length was deducted for each space slot
        
        StringBuilder line = new StringBuilder(words[i]);
        
        for(int k = i + 1; k <= j; ++k) {
            
            int spaceLength = (remWidth + spaceSlots - 1) / spaceSlots; // ceil division
            if(eot) spaceLength = 1;
            
            for(int s = 0; s < spaceLength; ++s)
                line.append(' ');
            
            remWidth -= spaceLength;
            spaceSlots--;
            line.append(words[k]);
        }
        
        while(line.length() < maxWidth) line.append(' ');

        List<String> para = solve(j + 1, words, maxWidth);
        para.add(line.toString());
        return para;
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> para = solve(0, words, maxWidth);
        Collections.reverse(para);
        return para;
    }
}