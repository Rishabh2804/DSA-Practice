class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> events = new ArrayList<>(); // To store both arrival and leave events

        // Populate events with {arrival, friendIndex} and {leave, -friendIndex}
        for (int i = 0; i < times.length; i++) {
            events.add(new int[] { times[i][0], i }); // Friend arrives
            events.add(new int[] { times[i][1], ~i }); // Friend leaves
        }

        Collections.sort(events, (a, b) -> a[0] - b[0]); // Sort events by time

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>(); // Min-heap for available chairs
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        ); // Min-heap to track when chairs will be vacated

        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i); // Initially all chairs are free
        }

        for (int[] event : events) {
            int time = event[0];
            int friendIndex = event[1];

            // Free up chairs when friends leave
            while (
                !occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= time
            ) {
                availableChairs.add(occupiedChairs.poll()[1]);
            }
            if (friendIndex >= 0) { // Friend arrives
                int chair = availableChairs.poll();
                if (friendIndex == targetFriend) {
                    return chair;
                }
                occupiedChairs.add(new int[] { times[friendIndex][1], chair }); // Mark when the chair will be vacated
            }
        }

        return -1; // Should never reach here
    }
}