class Solution {
    HashMap<Integer,Integer> mp;
    HashMap<String,Boolean> dp;
    public boolean canCross(int[] stones) {
        if(stones[1]!=1){
            return false;
        }
        mp=new HashMap<>();
        dp=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            mp.put(stones[i],i);
        }
        return jump(stones,1,1);
    }
    public boolean jump(int[] stones,int idx,int k){
        if(idx==stones.length-1){
            return true;
        }

        if(idx>=stones.length || idx<0){
            return false;
        }
        String key=idx+"|"+k;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        if(k-1>0){
            int nextidx=stones[idx]+(k-1);
            if(mp.containsKey(nextidx)){
                f1=jump(stones,mp.get(nextidx),k-1);
            }
        }
        int nextidx=stones[idx]+(k+1);
        if(mp.containsKey(nextidx)){
            f2=jump(stones,mp.get(nextidx),k+1);
        }
        int nidx=stones[idx]+k;
        if(mp.containsKey(nidx)){
            f3=jump(stones,mp.get(nidx),k);
        }
        boolean ans=f1 || f2 || f3;
        dp.put(key,ans);
        return ans;
    }
}