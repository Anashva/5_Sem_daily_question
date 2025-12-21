class Solution {
    public long minCost(String s, int[] cost) {
        long ans=0;
        HashMap<Character,Long> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            ans+=cost[i];
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0l)+cost[i]);
        }
        long max=0;
        for(long k:mp.values()){
            max=Math.max(max,k);
        }
        return  ans-max;
    }
}