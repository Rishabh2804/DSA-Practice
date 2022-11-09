class StockSpanner {

    Stack<Integer> spans;
    ArrayList<Integer> prices;
    int today;
    
    public StockSpanner() {
        spans = new Stack<>();
        prices = new ArrayList<>();
        today = -1;
    }
    
    public int next(int price) {
        today++;
        
        while(!spans.isEmpty() && prices.get(spans.peek()) <= price)
            spans.pop();
        
        int lastDay = -1;
        if(!spans.isEmpty())
            lastDay = spans.peek();
        
        prices.add(price);        
        spans.push(today);
        
        return today - lastDay;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */