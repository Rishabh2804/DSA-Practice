class Graph {
    static class coord {
        int first;
        int second;

        coord(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    int n;
    ArrayList<ArrayList<coord>> adjList;

    Graph(int n, int[][] edges) {
        this.n = n;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            adjList.get(u).add(new coord(v, cost));
        }
    }

    void addEdge(int[] edge) {
        int u = edge[0], v = edge[1], cost = edge[2];
        adjList.get(u).add(new coord(v, cost));
    }

    int shortestPath(int node1, int node2) {
        PriorityQueue<coord> pq = new PriorityQueue<>(n, (a, b) -> a.first - b.first);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[node1] = 0;
        pq.add(new coord(0, node1));

        while (!pq.isEmpty()) {
            int u = pq.peek().second;
            pq.poll();
            if (u == node2) {
                return dist[u];
            }

            for (var neighbor : adjList.get(u)) {
                int v = neighbor.first;
                int cost = neighbor.second;
                ;
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    pq.add(new coord(dist[v], v));
                }
            }
        }
        return -1;
    }
}