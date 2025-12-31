class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=1;i<=edges.length;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            int v1=e[0];
            int v2=e[1];
            if(bft(v1,v2,mp)){
                return e;
            }
            mp.get(v1).add(v2);
            mp.get(v2).add(v1);
        }
        return new int[0];
    }
    public boolean bft(int src,int des,HashMap<Integer,List<Integer>> mp){
        if(src==des){
            return true;
        }
        Queue<Integer> pq=new LinkedList<>();
        HashSet<Integer> st=new HashSet<>();
        pq.add(src);
        while(!pq.isEmpty()){
            int r=pq.poll();
            if(st.contains(r)){
                continue;
            }
            st.add(r);
            if(r==des){
                return true;
            }
            for(int nbrs:mp.get(r)){
                if(!st.contains(nbrs)){
                    pq.add(nbrs);
                }
            }
        }
        return false;
    }
}