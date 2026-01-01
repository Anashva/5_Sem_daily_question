class Solution {
    HashMap<Integer,List<Integer>> rmp;
    HashMap<Integer,List<Integer>> cmp;
    public int removeStones(int[][] stones) {
        rmp=new HashMap<>();
        cmp=new HashMap<>();
        int n=stones.length;
        for(int i=0;i<n;i++){
            int x=stones[i][0];
            int y=stones[i][1];
            rmp.putIfAbsent(x,new ArrayList<>());
            cmp.putIfAbsent(y,new ArrayList<>());
            rmp.get(x).add(i);
            cmp.get(y).add(i);
        }
        return n-bfs(n,stones);
    }
    public int bfs(int n,int[][] stones){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> st=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(st.contains(i)){
                continue;
            }
            ans++;
            q.add(i);
            while(!q.isEmpty()){
                int rp=q.poll();
                int r=stones[rp][0];
                int c=stones[rp][1];
                if(st.contains(rp)){
                    continue;
                }
                st.add(rp);
                for(int nbrs:rmp.get(r)){
                    if(!st.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
                for(int nbrs:cmp.get(c)){
                    if(!st.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
        }
        return ans;
    }
}