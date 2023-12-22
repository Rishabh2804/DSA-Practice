class LRUCache {

    static class Node {
        int key;
        int value;

        Node prev;
        Node next;            
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
        @Override
        public String toString(){
            return "{" + this.key + " : " + this.value + "} -->";
        }
    }

    int capacity;
    
    Node head, tail;
    HashMap<Integer, Node> nodes;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>();
    }
    
    private void print(){
//         Node temp = head;
//         while(temp != null){
//             System.out.print(temp);
//             temp = temp.next;
//         }
        
//         System.out.println();
    }
    
    private void add(int key, Node node){
        if(head == null){
            head = node;
            tail = node;
        } else{
            tail.next = node;
            node.prev = tail;
            
            tail = node;
        }
        
        nodes.put(key, node);                        
    }
    
    private Node remove(int key){
        
        Node node = nodes.get(key);
        if(head.key == node.key) head = head.next;
        else if(tail.key == node.key) tail = tail.prev;
        
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        
        node.next = null;
        node.prev = null;        
        
        nodes.remove(key);
        return node;
    }
    
    public int get(int key) {
        if(!nodes.containsKey(key)) return -1;
        
        // remove from mid and place at top
        Node node = remove(key);
        add(key, node);
        
        print();
        
        return nodes.get(key).value;
    }
    
    public void put(int key, int value) {
        if(nodes.containsKey(key)){
            Node node = remove(key);
            node.value = value;
            
            add(key, node);
            
            print();
            return;
        }

        if(nodes.size() >= capacity){
            Node node = remove(head.key); // remove old key from map
            
            node.key = key;
            node.value = value;                        
            
            add(key, node); // update map with node associated with new key            
        } else 
            add(key, new Node(key, value));                
        
        print();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */