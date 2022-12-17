class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token.charAt(token.length() - 1))){
                st.push(Integer.parseInt(token));
            }
            else {
                int b = st.pop();
                int a = st.pop();
                st.push(evaluate(a, b, token.charAt(0)));
            }
        }
    
        return st.pop();
    }

    public int evaluate(int a, int b, char c) {
        return switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

    public boolean isNumber(char c){
        return '0' <= c && c <= '9';
    }
}