class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (String word : words) 
            count.put(word, count.getOrDefault(word, 0) + 1);
        
        int answer = 0;
        int central = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            
            // word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = 1;
                }
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reversedWord)) {
                    answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                }
            }
        }
        
        return 2 * (answer + central);
    }
};