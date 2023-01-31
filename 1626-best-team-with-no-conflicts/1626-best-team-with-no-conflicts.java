class Solution {

        static class Player {
            int score;
            int age;

            public Player(int score, int age) {
                this.score = score;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Score : " + score + "; Age : " + age;
            }
        }

        public int bestTeamScore(int[] scores, int[] ages) {
            ArrayList<Player> players = new ArrayList<>();

            for (int i = 0; i < scores.length; ++i)
                players.add(new Player(scores[i], ages[i]));

            int[][] bestScores = new int[scores.length][scores.length];
            for (int[] row : bestScores)
                Arrays.fill(row, -1);

            Collections.sort(players,
                    (p1, p2) -> (p1.age == p2.age)
                            ? p1.score - p2.score
                            : p1.age - p2.age);

            return solve(0, -1, players, bestScores);
        }

        public int solve(int i, int prev, List<Player> players, int[][] bestScores) {
            if (i >= players.size())
                return 0;

            if (bestScores[i][prev + 1] != -1)
                return bestScores[i][prev + 1];

            int take = -1;
            if (prev == -1 || players.get(i).score >= players.get(prev).score)
                take = players.get(i).score + solve(i + 1, i, players, bestScores);

            int leave = solve(i + 1, prev, players, bestScores);

            return bestScores[i][prev + 1] = Math.max(take, leave);
        }
    }