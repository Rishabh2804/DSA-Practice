class Solution {

    public String frequencySort(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); ++i)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        StringBuilder sb = new StringBuilder();

        for (char c : freq.keySet())
            pq.add(c);

        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < freq.get(c); ++i)
                sb.append(c);
        }

        return sb.toString();
    }
}