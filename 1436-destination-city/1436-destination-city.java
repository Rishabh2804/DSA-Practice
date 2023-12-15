class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> outDeg = new HashMap<>();
        for(List<String> path : paths){
            String u = path.get(0);
            String v = path.get(1);
            
            outDeg.put(u, outDeg.getOrDefault(u, 0) + 1);
            outDeg.putIfAbsent(v, 0);
        }
        
        for(String city : outDeg.keySet()){
            if(outDeg.get(city) == 0) return city;
        }
        
        return "";
    }
}