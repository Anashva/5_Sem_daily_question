class Solution {
    HashMap<Integer,HashSet<Integer>> mp;
    public int maximalNetworkRank(int n, int[][] roads) {
        mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(i,new HashSet<>());
        }
        for(int[] e:roads){
            mp.get(e[0]).add(e[1]);
            mp.get(e[1]).add(e[0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int r=mp.get(i).size()+mp.get(j).size();
                if(mp.get(i).contains(j)){
                    r--;
                }
                ans=Math.max(ans,r);
            }
        }
        return ans;
    }
}