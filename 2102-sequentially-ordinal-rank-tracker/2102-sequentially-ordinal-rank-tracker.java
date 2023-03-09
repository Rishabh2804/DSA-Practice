import java.util.Collections;
import java.util.PriorityQueue;

class SORTracker {

    static class Location implements Comparable<Location> {
        String name;
        int score;

        Location(String name, int score) {
            this.name = name;
            this.score = score;

        }

        @Override
        public int compareTo(SORTracker.Location loc2) {
            if (score == loc2.score)
                return loc2.name.compareTo(name);
            else
                return score - loc2.score;
        }
    }

    PriorityQueue<Location> maxHeap;
    PriorityQueue<Location> minHeap;

    public SORTracker() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void add(String name, int score) {

        Location curr = new Location(name, score);

        // no get operation yet
        if (minHeap.isEmpty()) {
            maxHeap.add(curr);
            return;
        }

        if (curr.compareTo(minHeap.peek()) <= 0) {
            maxHeap.add(curr);
        } else {
            maxHeap.add(minHeap.poll());
            minHeap.add(curr);
        }
    }

    public String get() {
        Location res = maxHeap.poll();
        minHeap.add(res);
        return res.name;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */