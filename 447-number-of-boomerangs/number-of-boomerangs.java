class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> mp=new HashMap<>();
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                int x2=points[j][0];
                int y2=points[j][1];
                int dis=(x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                mp.put(dis,mp.getOrDefault(dis,0)+1);
            }
            for(int k:mp.values()){
                ans+=k*(k-1);
            }
        }
        return ans;
    }
}