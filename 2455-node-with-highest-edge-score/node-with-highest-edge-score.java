class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,Long> mp=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int node = edges[i];
            if (mp.containsKey(node)) {
                long sum = mp.get(node) + i;
                mp.put(node, sum);
            } else {
                mp.put(node, (long) i);
            }
        }
        long ans=-1;
        int node=0;
        for(int k:mp.keySet()){
            long c=mp.get(k);
            if(ans<c || (ans==c && k<node)){
                ans=c;
                node=k;
            }
        }
        return node;
    }
}