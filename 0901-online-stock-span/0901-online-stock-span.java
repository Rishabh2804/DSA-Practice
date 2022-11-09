class StockSpanner {

    Stack<Integer> spans;
    ArrayList<Integer> prices;
    
    public StockSpanner() {
        spans = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        
        while(!spans.isEmpty() && prices.get(spans.peek()) <= price)
            spans.pop();
        
        int lastDay = -1;
        if(!spans.isEmpty())
            lastDay = spans.peek();
        
        prices.add(price);        
        spans.push(prices.size() - 1);
        
        return prices.size() - 1 - lastDay;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */