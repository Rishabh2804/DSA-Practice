import java.util.*;
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
       
	        int sum=0;
	       // arrays = arrays.stream().distinct().collect(Collectors.toList());;
            int min = arrays.get(0).get(0);
            int max = arrays.get(0).get(arrays.get(0).size()-1);
                for(int j=1;j<arrays.size();j++){
	            sum= Math.max(sum,Math.abs(arrays.get(j).get(arrays.get(j).size()-1)-min));
	            sum= Math.max(sum,Math.abs(max-arrays.get(j).get(0)));
	            min = Math.min(min,arrays.get(j).get(0));
                max = Math.max(max,arrays.get(j).get(arrays.get(j).size()-1));
                }
	        
	        return sum;
	        

    }
}