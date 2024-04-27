class Solution {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    
    private static final int INF = 100;
    
    private void print(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    private void print2(int[][][] arr){
        System.out.println("Left : ");
        for(int i = 0; i < arr.length; ++i){
            System.out.print(i + ":  ");
            print(arr[i][LEFT]);
        }
        
        System.out.println("Right : ");
        for(int i = 0; i < arr.length; ++i){
            System.out.print(i + ":  ");
            print(arr[i][RIGHT]);
        }        
    }
    
    private int circulate(int i, int n){
        if(i < 0){
            int absPos = -1 * i;
            return n - (absPos % n);
        } else return i % n;
    }
    
    private int[] calculateSeekTime(int pos, int n, int[] ref, int dir){        
        
        int[] seekTime = new int[ref.length];
        for(int i = 0; i < ref.length; ++i){
            if(ref[i] == -1) seekTime[i] = INF;
            else {
                if(dir == LEFT) seekTime[i] = circulate(pos - ref[i], n);
                else seekTime[i] = circulate(ref[i] - pos, n);
            }
        }

        return seekTime;
    }
    
    private int[][][] getSeekTime(String disk){
        
        int n = disk.length();
        int[][][] seekTimes = new int[n][2][26];
        
        // left
        int[] reg = new int[26];
        Arrays.fill(reg, -1);
        
        for(int i = 0; i < 2 * n; ++i){
            int idx = i % n;
            int curr = disk.charAt(idx) - 'a';
            reg[curr] = idx;
            
            seekTimes[idx][LEFT] = calculateSeekTime(idx, n, reg, LEFT);
        }
        
        // right        
        Arrays.fill(reg, -1);
        for(int i = 0; i < 2 * n; ++i){
            int idx = n - (i % n) - 1;
            int curr = disk.charAt(idx) - 'a';
            reg[curr] = idx;
            
            seekTimes[idx][RIGHT] = calculateSeekTime(idx, n, reg, RIGHT);            
        }
        
        return seekTimes;
    }
    
    private int solve(int ioHead, String disk, int req, String key, int[][][] seekTimes, int[][] dp){
        if(req >= key.length()) return 0;
        
        if(dp[ioHead][req] != -1) return dp[ioHead][req];
        
        if(disk.charAt(ioHead) == key.charAt(req)) 
            return 1 + solve(ioHead, disk, req + 1, key, seekTimes, dp);
        
        int reqID = key.charAt(req) - 'a';        
        int leftSeekTime = seekTimes[ioHead][LEFT][reqID];
        int leftSeekPos = circulate(ioHead - leftSeekTime, disk.length());
        
        int rightSeekTime = seekTimes[ioHead][RIGHT][reqID];
        int rightSeekPos = circulate(ioHead + rightSeekTime, disk.length());
        
        int seekLeft = 1 + leftSeekTime + solve(leftSeekPos, disk, req + 1, key, seekTimes, dp);
        int seekRight = 1 + rightSeekTime + solve(rightSeekPos, disk, req + 1, key, seekTimes, dp);
        
        return dp[ioHead][req] = Math.min(seekLeft, seekRight);        
    }
    
    public int findRotateSteps(String ring, String key) {
        
        int[][][] seekTimes = getSeekTime(ring);
        int[][] dp = new int[ring.length()][key.length()];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        
        return solve(0, ring, 0, key, seekTimes, dp);
    }
}