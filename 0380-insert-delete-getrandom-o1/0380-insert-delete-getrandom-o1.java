class RandomizedSet {

    ArrayList<Integer> set;
    
    public RandomizedSet() {
        set = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        else{
            set.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!set.contains(val))
            return false;
        else{
            set.remove(set.indexOf(val));
            return true;
        }
    }
    
    public int getRandom() {
        int randomIdx = (int) (Math.random() * set.size());
        return set.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */