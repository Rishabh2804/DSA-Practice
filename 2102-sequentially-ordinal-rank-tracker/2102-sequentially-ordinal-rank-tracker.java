import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class SORTracker implements Comparator<String> {

    HashMap<String, Integer> scores;

    PriorityQueue<String> maxHeap;
    PriorityQueue<String> minHeap;

    @Override
    public int compare(String loc1, String loc2) {
        if (scores.get(loc1).equals(scores.get(loc2)))
            return loc2.compareTo(loc1);

        return scores.get(loc1) - scores.get(loc2);
    }

    public SORTracker() {
        scores = new HashMap<>();

        minHeap = new PriorityQueue<>(this);
        maxHeap = new PriorityQueue<>(Collections.reverseOrder(this));
    }

    public void add(String name, int score) {

        scores.put(name, score);

        // no get operation yet
        if (minHeap.isEmpty()) {
            maxHeap.add(name);
            return;
        }

        if (compare(name, minHeap.peek()) <= 0) {
            maxHeap.add(name);
        } else {
            maxHeap.add(minHeap.poll());
            minHeap.add(name);
        }
    }

    public String get() {
        String res = maxHeap.poll();
        minHeap.add(res);
        return res;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */