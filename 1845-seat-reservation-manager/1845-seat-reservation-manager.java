class SeatManager {
    
    private PriorityQueue<Integer> seats;
    
    private void init(int n){
        seats = new PriorityQueue<>();
        for(int seatNumber = 1; seatNumber <= n; ++seatNumber)
            seats.add(seatNumber);
    }
    
    public SeatManager(int n) {
        init(n);
    }
    
    public int reserve() {
        return seats.poll();
    }
    
    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */