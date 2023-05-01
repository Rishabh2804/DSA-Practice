class Solution {
    public double average(int[] salary) {
        int maxSal = Integer.MIN_VALUE, minSal = Integer.MAX_VALUE;
        
        double sum = 0;
        for(int sal : salary){
            maxSal = Math.max(maxSal, sal);
            minSal = Math.min(minSal, sal);
            sum += sal;
        }
        
        sum -= maxSal + minSal;
        return sum / (salary.length - 2);        
    }
}