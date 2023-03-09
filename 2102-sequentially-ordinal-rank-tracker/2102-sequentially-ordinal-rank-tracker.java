class SORTracker {

    class TrackedEntry implements Comparable<TrackedEntry> {
        int score;
        String name;

        public TrackedEntry(String _name, int _score) {
            score = _score;
            name = _name;
        }

        @Override
        public int compareTo(TrackedEntry other) {
            int result = Integer.compare(score, other.score);
            if (result != 0) {
                return  result;
            }

            return other.name.compareTo(name);
        }
    }

    int getCounter;
    PriorityQueue<TrackedEntry> minPq;
    PriorityQueue<TrackedEntry> maxPq;

    public SORTracker() {
        getCounter = 1;
        minPq = new PriorityQueue<TrackedEntry>((x, y) -> x.compareTo(y));
        maxPq = new PriorityQueue<TrackedEntry>((x, y) -> y.compareTo(x));
    }
    
    public void add(String name, int score) {
        var entry = new TrackedEntry(name, score);

        if (minPq.isEmpty() || entry.compareTo(minPq.peek()) > 0) {
            minPq.add(entry);
        } else {
            maxPq.add(entry);
        }

        while (minPq.size() > getCounter) {
            maxPq.add(minPq.poll());
        }
    }
    
    public String get() {
        while (!maxPq.isEmpty() && minPq.size() < getCounter) {
            minPq.add(maxPq.poll());
        }

        getCounter++;
        return minPq.peek().name;
    }
}
