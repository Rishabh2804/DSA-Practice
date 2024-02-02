class Solution {
    
    private static final List<Integer> SEQ_NUM;
    static {
        SEQ_NUM = getEndingWith(9);
        Collections.sort(SEQ_NUM);
    }
    
    private static List<Integer> getEndingWith(int dig){
        List<Integer> seq;
        if(dig == 1){
            seq = new ArrayList<>();
            seq.add(1);
            return seq;
        }
        
        seq = getEndingWith(dig - 1);
        int size = seq.size();
        for(int i = size - 1; i >= 0; --i){
            int curr = seq.get(i);
            if(curr % 10 == dig - 1) seq.add(10 * curr + dig);
        }
        
        seq.add(dig);
        
        return seq;
    }
    
    private int lowerBound(int low){
        int si = 0, ei = SEQ_NUM.size();
        while(si < ei){
            int mid = (si + ei) / 2;
            if(SEQ_NUM.get(mid) >= low) ei = mid;
            else si = mid + 1;
        }
        
        return si;
    }
    
    private int upperBound(int high){
        int si = 0, ei = SEQ_NUM.size() - 1;
        while(si < ei){
            int mid = (si + ei + 1) / 2;
            if(SEQ_NUM.get(mid) <= high) si = mid;
            else ei = mid - 1;
        }
        
        if(SEQ_NUM.get(ei) > high) return -1;
        return ei;
    }
    
    private List<Integer> getRange(int low, int high){
        int si = lowerBound(low);
        int ei = upperBound(high);
        
        List<Integer> res = new ArrayList<>();
        for(int i = si; i <= ei; ++i) 
            res.add(SEQ_NUM.get(i));
        
        return res;
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        return getRange(low, high);        
    }
}