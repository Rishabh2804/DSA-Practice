class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.putIfAbsent(i, 0);
            freq.put(i, freq.get(i) + 1);
        }
        
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; ++i) arr[i] = nums[i];
        
        Arrays.sort(arr, (a, b) -> {
            if(freq.get(a) == freq.get(b)) return b - a;
            else return freq.get(a) - freq.get(b);
        });
        
        for(int i = 0; i < nums.length; ++i) nums[i] = arr[i];
        return nums;
    }
}