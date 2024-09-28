class MyCircularDeque {
    
    class Node {
        int val;
        Node next;
        Node prev;
        
        public Node(int val){
            this.val = val;
        }
        
        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    
    private Node front;
    private Node rear;
    private int size;
    private int cap;
    
    public MyCircularDeque(int k) {
        this.size = 0;
        this.cap = k;
    }
    
    private Node insertNew(int value){
        
        Node newNode = new Node(value, front, rear);
        if(front == null)
            front = rear = newNode;
        else {
            front.prev = newNode;
            rear.next = newNode;
        }
        
        size++;
        return newNode;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = insertNew(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
    
        rear = insertNew(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        
        if (front == rear) {
            front = rear = null;
            size = 0;
            return true;
        }
        
        front = front.next;
        front.prev = rear;
        rear.next = front;
        
        size --;
        return true;
    }
    
    public boolean deleteLast() {    
        if (isEmpty()) return false;

        if (front == rear) {
            front = rear = null;
            size = 0;
            return true;
        }
        
        rear = rear.prev;
        front.prev = rear;
        rear.next = front;
        
        size --;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return front.val;
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return rear.val;            
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size >= cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */