class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int empty = 0;
        
        while(numBottles > 0){           
            int temp = (numBottles + empty) / numExchange;
            empty = (numBottles + empty) % numExchange;
            
            numBottles = temp;
            count += numBottles;
        }
        
        return count;
    }
}