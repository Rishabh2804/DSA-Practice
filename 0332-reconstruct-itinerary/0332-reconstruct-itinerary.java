class Solution {
    
    private boolean solve(String curr, HashMap<String, List<String>> adj, ArrayList<String> vis){
        
        // vis.add(curr);
        if(adj.get(curr) == null || adj.get(curr).isEmpty()) return true; // terminal reached
        
        List<String> buffer = new LinkedList<>();
        
        while(!adj.get(curr).isEmpty()){
            String to = adj.get(curr).remove(0);
            
            boolean reached = solve(to, adj, vis) && adj.get(curr).isEmpty();
            if(reached) {
                vis.add(to);
                return true;
            } else
                adj.get(curr).add(to);
        }
        
        // reach here only if no path existed from curr
        // adj.put(curr, buffer);
        
        return adj.get(curr).isEmpty();
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        ArrayList<String> vis = new ArrayList<>();
        
        HashMap<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            List<String> connected = adj.getOrDefault(from, new LinkedList<>());
            connected.add(to);
            
            adj.put(from, connected);
        }
        
        for(String city : adj.keySet()){
            Collections.sort(adj.get(city));
        }
        
        solve("JFK", adj, vis);
        vis.add("JFK");
        
        Collections.reverse(vis);
        
        return vis;
    }
}