class Solution {

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
            char curr = s.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                Parenthesis open = new Parenthesis(curr);
                open.next = top;
                top = open;
            } else {
                if (top == null)
                    return false;

                char topChar = top.type;
                if (topChar == '(' && curr != ')')
                    return false;
                else if (topChar == '{' && curr != '}')
                    return false;
                else if (topChar == '[' && curr != ']')
                    return false;

                top = top.next;
            }
        }

        return top == null;
    }

}
