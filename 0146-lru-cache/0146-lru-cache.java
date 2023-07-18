class LRUCache {
    
    static class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;
        
        public DListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    DListNode head;
    DListNode tail;

    HashMap<Integer, DListNode> db;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        db = new HashMap<>();
    }
    
    private void moveToLast(int key){
        DListNode node = db.get(key);

        // remove it from current position
        if(node == tail){
            // already at required position
            return;
        } else if(node == head){
            node.next.prev = null;
            head = node.next;                
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;                
        }
        
        // place it at the end (most recent)
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;            
    }
    
    public int get(int key) {
        if(db.containsKey(key)) {
            moveToLast(key);
            return db.get(key).val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(db.containsKey(key)){
            moveToLast(key);            
            db.get(key).val = value;
        } else {
            
            if(db.size() < capacity){   
                if(tail == null){
                    head = new DListNode(key, value);
                    tail = head;
                } else {
                    tail.next = new DListNode(key, value);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            } else {
                // instead of creating new node, 
                // we can recycle the node to be removed
                
                moveToLast(head.key);
                
                // removing old value from db
                db.remove(tail.key);
                tail.key = key;
                tail.val = value;
            }
            
            db.put(key, tail);
        }
        
    }
}
