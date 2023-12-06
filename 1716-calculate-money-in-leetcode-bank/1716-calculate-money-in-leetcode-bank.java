class Solution {
    
    static final int WEEK_MONEY = 28; // Money in first week
    
    private int apSum(int n, int a, int d){
        return n*(2*a + (n - 1)*d) / 2;
    }
    
    public int totalMoney(int n) {
        int weeks = n / 7;
        int extraDays = n % 7;
        
        return apSum(weeks, WEEK_MONEY, 7) 
            + apSum(extraDays, weeks + 1, 1);
    }
}