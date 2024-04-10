class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        
        for(int i = deck.length - 1; i >= 0; --i){
            if(!q.isEmpty()) q.add(q.poll());
            q.add(deck[i]);
        }
        
        int[] res = new int[deck.length];
        int i = res.length - 1;
        while(i >= 0){
            res[i] = q.poll();
            i--;
        }
        
        return res;
    }
}

// 2 3 5 7 11 13 17

// 17
// 13 17
// 11 17 13

// 7 13 11 17
// 5 17 7 13 11
// 3 11 5 17 7 13
// 2 13 3 11 5 17 7