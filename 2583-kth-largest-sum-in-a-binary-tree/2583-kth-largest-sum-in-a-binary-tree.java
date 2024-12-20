class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long> sum = new PriorityQueue<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            
            int size = nodes.size();            
            long currSum = 0L;
            
            while(size --> 0){
                TreeNode curr = nodes.poll();
                currSum += curr.val;
                
                if (curr.left != null) nodes.add(curr.left);
                if (curr.right != null) nodes.add(curr.right);
            }
            
            sum.add(currSum);
            if(sum.size() > k) sum.poll();
        }
        
        if (sum.size() < k) return -1L;
        else return sum.poll();
    }
}