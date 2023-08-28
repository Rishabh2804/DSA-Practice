class MyStack {

    Queue<Integer> active;
    Queue<Integer> aux;
    
    public MyStack() {
        active = new LinkedList<>();
        aux = new LinkedList<>();
    }
    
    public void push(int x) {
        aux.add(x);
        while(!active.isEmpty())
            aux.add(active.poll());
        
        Queue<Integer> temp = aux;
        aux = active;
        active = temp;
    }
    
    public int pop() {
        return active.poll();
    }
    
    public int top() {
        return active.peek();
    }
    
    public boolean empty() {
        return active.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */