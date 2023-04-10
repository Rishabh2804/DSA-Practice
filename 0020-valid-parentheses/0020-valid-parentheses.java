public class Solution {

    static class Parenthesis {
        char type;
        Parenthesis next;

        Parenthesis(char type) {
            this.type = type;
        }
    }

    public boolean isValid(String s) {

        Parenthesis top = null;
        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                Parenthesis open = new Parenthesis(s.charAt(i));
                open.next = top;
                top = open;
            } else {
                if (top == null)
                    return false;

                char topChar = top.type;
                if (topChar == '(' && s.charAt(i) != ')')
                    return false;
                else if (topChar == '{' && s.charAt(i) != '}')
                    return false;
                else if (topChar == '[' && s.charAt(i) != ']')
                    return false;

                top = top.next;
            }
        }

        return top == null;
    }

}
