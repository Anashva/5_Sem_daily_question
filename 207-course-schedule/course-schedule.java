class Solution {
    HashMap<Integer,List<Integer>> mp;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        mp=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            mp.put(i,new ArrayList<>());
        }
        for(int e[] :prerequisites){
            int v1=e[0];
            int v2=e[1];
            mp.get(v1).add(v2);
        }

        int[] in=indegree();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int r=q.poll();
            c++;
            for(int nbrs:mp.get(r)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        return c==mp.size();

    }
    public int[] indegree(){
        int[] in=new int[mp.size()];
        for(int v1:mp.keySet()){
            for(int v2:mp.get(v1)){
                in[v2]++;
            }
        }
        return in;
    }
    
}