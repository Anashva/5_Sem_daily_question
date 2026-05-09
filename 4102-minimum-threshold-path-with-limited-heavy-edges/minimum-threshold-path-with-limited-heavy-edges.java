class Solution {

    List<int[]>[] graph;

    public int minimumThreshold(int n, int[][] edges,
                                int src, int des, int k) {

        if (src == des) {
            return 0;
        }

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int mx = 0;

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});

            mx = Math.max(mx, w);
        }

        int ans = -1;

        int l = 0;
        int h = mx;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (path(src, des, mid, n, k)) {
                ans = mid;
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean path(int src, int des,
                        int thd, int n, int k) {

        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[1], b[1]));

        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int[] rp = pq.poll();

            int vtx = rp[0];
            int wt = rp[1];

            if (wt > dis[vtx]) {
                continue;
            }

            for (int[] edge : graph[vtx]) {

                int nbr = edge[0];
                int w = edge[1];

                int cost = (w > thd) ? 1 : 0;

                if (wt + cost < dis[nbr]) {

                    dis[nbr] = wt + cost;

                    pq.add(new int[]{nbr, dis[nbr]});
                }
            }
        }

        return dis[des] <= k;
    }
}