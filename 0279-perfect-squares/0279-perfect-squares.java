class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n))
            return 1;

        Queue<Integer> num = new LinkedList<>();
        num.add(n);

        int ans = 0;
        while (!num.isEmpty()) {
            ans++;
            int size = num.size();
            for (int i = 0; i < size; ++i) {
                int curr = num.poll();
                if (isPerfectSquare(curr))
                    return ans;

                for (int j = (int) Math.sqrt(curr); j >= 1; --j)
                    num.add(curr - j * j);
            }
        }

        return ans;
    }

    public boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);

        return (sqrt * sqrt) == n;
    }
}