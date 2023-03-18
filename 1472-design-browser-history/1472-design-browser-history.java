class BrowserHistory {

    static class URL{
        String url;
        URL next;
        URL prev;
        
        URL(String url){
            this.url = url;            
        }
    }
    
    URL home;
    URL curr;
    
    public BrowserHistory(String homepage) {
        home = new URL(homepage);
        curr = home;
    }
    
    public void visit(String url) {
        curr.next = new URL(url);
        curr.next.prev = curr;
        
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(curr != home && steps --> 0)
            curr = curr.prev;
        
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next != null && steps --> 0)
            curr = curr.next;
        
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */