class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans=new ArrayList<>();
        int[] in=new int[numCourses];
        List<Integer>[] ll=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            ll[i]=new ArrayList<>();
        }
        for(int[] e:prerequisites){
            int v1=e[0];
            int v2=e[1];
            ll[v1].add(v2);
            in[v2]++;
        }
        boolean[][] visit=new boolean[numCourses][numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int r=q.poll();
            for(int nbr:ll[r]){
                visit[r][nbr]=true;
                for(int i=0;i<numCourses;i++){
                    if(visit[i][r]){
                        visit[i][nbr]=true;
                    }
                }
                in[nbr]--;
            if(in[nbr]==0){
                q.add(nbr);
            }
            }
        }
        for(int[] e:queries){
            ans.add(visit[e[0]][e[1]]);
        }
        return ans;
    }
}