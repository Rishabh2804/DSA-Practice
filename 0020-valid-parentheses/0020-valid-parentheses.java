class Solution {

    public static final int openID(char c) {
        return switch (c) {
            case '(' -> 0;
            case '[' -> 1;
            case '{' -> 2;
            default -> -1;
        };
    }

    public static final int closeID(char c) {
        return switch (c) {
            case ')' -> 0;
            case ']' -> 1;
            case '}' -> 2;
            default -> -2;
        };
    }

    public boolean isValid(String s) {

        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (openID(s.charAt(i)) >= 0)
                parenthesis.push(s.charAt(i));
            else if(parenthesis.isEmpty())
                return false;
            else if (closeID(s.charAt(i)) != openID(parenthesis.pop()))
                return false;
        }

        return parenthesis.isEmpty();
    }

}
