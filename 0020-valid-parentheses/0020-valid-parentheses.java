class Solution {

    public boolean isValid(String s) {
        char curr;

        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[')
                parenthesis.push(s.charAt(i));
            else if (parenthesis.isEmpty())
                return false;
            else {
                char top = parenthesis.peek();
                if (top == '(' && curr == ')')
                    parenthesis.pop();
                else if (top == '{' && curr == '}')
                    parenthesis.pop();
                else if (top == '[' && curr == ']')
                    parenthesis.pop();
                else
                    return false;
            }
        }

        return parenthesis.isEmpty();
    }

}
