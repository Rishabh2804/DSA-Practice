class Solution {
    
    private static final String OPERATORS = "+-*/";
    private static final boolean isOperator(String token){
        return OPERATORS.indexOf(token) >= 0;
    }
    
    private static final int eval(int a, int b, String op){
        return switch(op){
            case "+" : yield a + b;
            case "-" : yield a - b;
            case "*" : yield a * b;
            case "/" : yield a / b;
            default : yield 0;
        };
    }    
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> evaluator = new Stack<>();
        for(String token : tokens){
            if(isOperator(token)){
                int b = evaluator.pop();
                int a = evaluator.pop();
                
                int res = eval(a, b, token);
                
                evaluator.add(res);
            } else evaluator.add(Integer.parseInt(token));
        }
        
        return evaluator.pop();
    }
}