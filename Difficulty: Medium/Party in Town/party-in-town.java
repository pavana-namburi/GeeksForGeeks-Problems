class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        int[] firstBFS = bfs(0, n, adj);
        int farthestNode = firstBFS[0];

        int[] secondBFS = bfs(farthestNode, n, adj);
        int diameter = secondBFS[1];

        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] > maxDist) {
                maxDist = dist[curr];
                farthestNode = curr;
            }

            for (int neighbor : adj.get(curr)) {
                int nextNode = neighbor - 1;
                if (dist[nextNode] == -1) {
                    dist[nextNode] = dist[curr] + 1;
                    queue.add(nextNode);
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }
}
