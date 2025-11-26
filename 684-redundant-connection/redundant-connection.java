class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=1;i<=edges.length;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int e[]:edges){
            int v1=e[0];
            int v2=e[1];
            if(bfs(v1,v2,mp)){
                return e;
            }
            mp.get(v1).add(v2);
            mp.get(v2).add(v1);
        }
        return new int [0];
    }
    public boolean bfs(int src,int des,HashMap<Integer,List<Integer>> mp){
        if(src==des){
            return true;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        HashSet<Integer> st=new HashSet<>();
        while(!q.isEmpty()){
            // remove
            int rv=q.poll();
            // ignore
            if(st.contains(rv)){
                continue;
            }
            // mark visited
            st.add(rv);
            // self work
            if(rv==des){
                return true;
            }
            // add nbrs
            for(int nbrs:mp.get(rv)){
                if(!st.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}