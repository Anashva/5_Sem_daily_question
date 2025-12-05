class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> st=new HashSet<>();
        Queue<Integer> pq=new LinkedList<>();
        pq.add(0);
        while(!pq.isEmpty()){
            int r=pq.poll();
            if(st.contains(r)){
                continue;
            }
            st.add(r);
            for(int nbrs:rooms.get(r)){
                if(!st.contains(nbrs)){
                    pq.add(nbrs);
                }
            }
        }
        return st.size()==rooms.size();
    }
}