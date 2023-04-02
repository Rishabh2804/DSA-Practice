
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int i = 0;
        for (int spell : spells) {
            int ans1 = bSearch(potions, spell, success);
            if (ans1 == -1)
                result[i++] = 0;
            else
                result[i++] = potions.length - bSearch(potions, spell, success);
        }
        return result;
    }

    public static int bSearch(int[] arr, int spell, long tar) {
        int i = 0, j = arr.length - 1;
        int mid = (i + j) / 2;
        boolean done = false;
        while (i <= j) {
            if (i == j) {
                long p = (long) spell * (long) arr[i];
                if (p >= tar)
                    done = true;
                break;
            }
            mid = (i + j) / 2;
            long p = (long) spell * (long) arr[mid];
            if (p < tar)
                i = mid + 1;
            else {
                done = true;
                j = mid;
            }
        }
        if (!done)
            return -1;

        return i;
    }
}