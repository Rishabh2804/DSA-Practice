class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(int i = 0; i < details.length; i++){
            if(10 * (details[i].charAt(11) - '0') + (details[i].charAt(12)-'0') > 60) count++;
        }
        return count;
    }
}