class DataStream {

    int value;
    int k;
    int cons;    
    
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;        
    }
    
    public boolean consec(int num) {
        if(num == value)
            cons++;
        else 
            cons = 0;
        
        return cons >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */