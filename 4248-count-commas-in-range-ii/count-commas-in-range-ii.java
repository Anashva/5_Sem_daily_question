class Solution {
    public long countCommas(long n) {
        long ans=0;
        long val=1000;
        int c=1;
        while(val<=n){
            long d=Math.min(n,val*1000-1);
            ans+=(d-val+1)*c;
            val*=1000;
            c++;
        }
        return ans;
    }
}