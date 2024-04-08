class Solution {
    public int countStudents(int[] students, int[] sandwiches) {        
        Queue<Integer> q = new LinkedList<>();
        
        int zeroes = 0;
        int ones = 0;
        for(int i : students) {            
            q.add(i);
            
            if(i == 0) zeroes ++;
            else ones ++;
        }
        
        
        int j = 0;
        while(j < sandwiches.length){
            if(sandwiches[j] == q.peek()){
                q.poll();
                if(sandwiches[j] == 0) zeroes --;
                else ones --;
                    
                j++;
            } else {
                if(sandwiches[j] == 0 && zeroes <= 0) return q.size();
                else if(sandwiches[j] == 1 && ones <= 0) return q.size();
                
                else q.add(q.poll());
            }
        }
        
        return q.size();
    }
}