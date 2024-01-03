class Solution {
    public int numberOfBeams(String[] bank) {
        
        int beams = 0;
        
        int curr = 0;
        for(String floor : bank){
            int securityDeviceCount = 0;
            for(int i = 0; i < floor.length(); ++i)
                securityDeviceCount += floor.charAt(i) - '0';
            
            if(securityDeviceCount == 0) continue;
            
            beams += curr * securityDeviceCount;
            curr = securityDeviceCount;
        }
        
        return beams;
    }
}