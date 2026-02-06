class Solution {
    HashMap<Integer,HashSet<Integer>> mp;
    public int minTrioDegree(int n, int[][] edges) {
        mp=new HashMap<>();
        for(int i=1;i<=n;i++){
            mp.put(i,new HashSet<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(mp.containsKey(i)){
                for(int j=i+1;j<=n;j++){
                    if(mp.get(i).contains(j)){
                        for(int k=j+1;k<=n;k++){
                            if(mp.get(j).contains(k) && mp.get(i).contains(k)){
                               int n1=mp.get(i).size(); 
                               int n2=mp.get(j).size(); 
                               int n3=mp.get(k).size();
                               ans=Math.min(ans,n1+n2+n3-6); 
                            }
                        }
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}