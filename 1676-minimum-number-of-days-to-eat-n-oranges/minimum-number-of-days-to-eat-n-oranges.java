class Solution {
    HashMap<Integer,Integer> mp;
    public int minDays(int n) {
        mp=new HashMap<>();
        return count(n);
    }
    public int count(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,n%2+count(n/2));
        ans=Math.min(ans,n%3+count(n/3));
        mp.put(n,ans+1);
        return ans+1;
    }
}