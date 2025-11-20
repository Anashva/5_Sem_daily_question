class Solution {
    private HashMap<Integer, HashMap<Integer,Integer>> map;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    AddEdge(i,j,1);
                }
            }
        }
        return bft();
    }
    public void AddEdge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public int bft(){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        int c=0;
       for (int src:map.keySet()){
           if(visited.contains(src)){
               continue;
           }
           q.add(src);
           c++;
           while(!q.isEmpty()){
//            1 remove
               int r=q.poll();

//            2 ignore if already visited
               if(visited.contains(r)){
                   continue;
               }

//            3 marked visited
               visited.add(r);

//            4 self work

//            5 add unvisited nbrs
               for (int nbrs:map.get(r).keySet()){
                   if(!visited.contains(nbrs)){
                       q.add(nbrs);
                   }
               }
           }
       }
       return c;
    }

}