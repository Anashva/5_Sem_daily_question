class Solution {
    Long[][][][] dp;
    public long countDistinct(long n) {
        String s=Long.toString(n);
        dp=new Long[s.length()][2][2][2];
        return count(s,0,1,1,0);
    }
    public long count(String s,int idx,int tight,int lz,int zero){
        if(idx==s.length()){
            if(lz==0){
                return zero==1 ? 0:1;
            }
            return 0;
        }
        if(dp[idx][tight][lz][zero]!=null){
            return dp[idx][tight][lz][zero];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' : 9;
        long ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0){
                ans+=count(s,idx+1,newt,lz,zero);
            }
            else{
                int nzero=(digit==0) ? 1:zero;
                int nlz=(lz==1 && digit==0) ? 1:0;
                ans+=count(s,idx+1,newt,nlz,nzero);
            }
        }
        return dp[idx][tight][lz][zero]=ans;
    }
}