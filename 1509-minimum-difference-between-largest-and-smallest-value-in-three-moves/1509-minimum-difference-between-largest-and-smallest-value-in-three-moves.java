public class Solution {

    public int minDifference(int[] nums) {
        int numsSize = nums.length;
        if (numsSize <= 4) {
            return 0;
        }

        // Find the four smallest elements using a fixed-size max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        Collections.sort(smallestFour);

        // Find the four largest elements using a fixed-size min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(largestFour);

        int minDiff = Integer.MAX_VALUE;
        // Four scenarios to compute the minimum difference
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(
                minDiff,
                largestFour.get(i) - smallestFour.get(i)
            );
        }

        return minDiff;
    }
}