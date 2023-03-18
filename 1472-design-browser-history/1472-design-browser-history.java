class BrowserHistory {

    Stack<String> backStack;
    Stack<String> forStack;
    
    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        backStack.add(homepage);
        
        forStack = new Stack<>();
    }
    
    public void visit(String url) {
        backStack.push(url);
        forStack = new Stack<>();
    }
    
    public String back(int steps) {
        while(backStack.size() > 1 && steps --> 0)
            forStack.add(backStack.pop());
        
        return backStack.peek();
    }
    
    public String forward(int steps) {
        while(!forStack.isEmpty() && steps --> 0)
            backStack.add(forStack.pop());
        
        return backStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */