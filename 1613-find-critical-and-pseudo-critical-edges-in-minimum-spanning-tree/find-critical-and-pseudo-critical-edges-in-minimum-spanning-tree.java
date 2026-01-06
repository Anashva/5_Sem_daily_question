class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> mp;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(i, new HashMap<>());
        }

        for (int[] e : edges) {
            mp.get(e[0]).put(e[1], e[2]);
            mp.get(e[1]).put(e[0], e[2]);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> critical1 = new ArrayList<>();
        List<Integer> critical2 = new ArrayList<>();

        int ans = Kruskal_Algo();

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];

            mp.get(v1).remove(v2);
            mp.get(v2).remove(v1);

            int nans = Kruskal_Algo();

            if (nans > ans) {
                critical1.add(i);
            } 
            else {
                int wt = forceIncludeEdge(edges[i]);
                if (wt == ans) { 
                    critical2.add(i);
                }
            }

            mp.get(v1).put(v2, edges[i][2]);
            mp.get(v2).put(v1, edges[i][2]);
        }

        res.add(critical1);
        res.add(critical2);
        return res;
    }

    class EdgePair {
        int e1;
        int e2;
        int cost;

        public EdgePair(int e1, int e2, int cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
    }
    public int forceIncludeEdge(int[] edge) {
        List<EdgePair> ll = getAllEdge();
        Collections.sort(ll, (a, b) -> a.cost - b.cost);

        DisJoinSet dsu = new DisJoinSet();
        for (int v : mp.keySet()) {
            dsu.create(v);
        }
        int ans = 0;
        int count = 0;

        if (dsu.find(edge[0]) != dsu.find(edge[1])) {
            dsu.union(edge[0], edge[1]);
            ans += edge[2];
            count++;
        }
        
        for (EdgePair e : ll) {
            if (e.e1 == edge[0] && e.e2 == edge[1] && e.cost == edge[2]) {
                continue; // skip duplicate
            }
            int re1 = dsu.find(e.e1);
            int re2 = dsu.find(e.e2);
            if (re1 != re2) {
                dsu.union(re1, re2);
                ans += e.cost;
                count++;
            }
        }
        return (count == mp.size() - 1) ? ans : Integer.MAX_VALUE;
    }


    public List<EdgePair> getAllEdge() {
        List<EdgePair> ll = new ArrayList<>();
        for (int e1 : mp.keySet()) {
            for (int e2 : mp.get(e1).keySet()) {
                int cost = mp.get(e1).get(e2);
                if(e1<e2){
                    ll.add(new EdgePair(e1, e2, cost));
                }
            }
        }
        return ll;
    }

    public int Kruskal_Algo() {
        List<EdgePair> ll = getAllEdge();
        Collections.sort(ll, (a, b) -> a.cost - b.cost);

        DisJoinSet dsu = new DisJoinSet();
        for (int v : mp.keySet()) {
            dsu.create(v);
        }

        int ans = 0;
        int c=0;
        for (EdgePair e : ll) {
            int re1 = dsu.find(e.e1);
            int re2 = dsu.find(e.e2);

            if (re1 != re2) {
                dsu.union(re1, re2);
                ans += e.cost;
                c++;
            }
        }
        if(c!=mp.size()-1){
            return Integer.MAX_VALUE;
        }
        return ans;
    }

    public class DisJoinSet {

        class Node {
            int val;
            int rank;
            Node parent;
        }

        private HashMap<Integer, Node> map = new HashMap<>();

        public void create(int v) {
            Node nn = new Node();
            nn.val = v;
            nn.rank = 0;
            nn.parent = nn;
            map.put(v, nn);
        }

        public int find(int v) {
            Node node = map.get(v);
            return find(node).val;
        }

        private Node find(Node node) {
            if (node.parent == node) {
                return node;
            }
            node.parent = find(node.parent);
            return node.parent;
        }

        public void union(int v1, int v2) {
            Node re1 = find(map.get(v1));
            Node re2 = find(map.get(v2));

            if (re1.rank == re2.rank) {
                re1.parent = re2;
                re2.rank++;
            } else if (re1.rank < re2.rank) {
                re1.parent = re2;
            } else {
                re2.parent = re1;
            }
        }
    }
}
