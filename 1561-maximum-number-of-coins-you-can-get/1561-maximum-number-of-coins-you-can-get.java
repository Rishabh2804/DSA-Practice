class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int coins = 0;
        for(int i = piles.length / 3; i < piles.length; i += 2)
            coins += piles[i];
        
        return coins;
    }
}

// 8 7 4 2 2 1