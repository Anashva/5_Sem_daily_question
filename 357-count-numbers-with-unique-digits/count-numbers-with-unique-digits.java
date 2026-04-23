class Solution {
    Integer [][][][] dp;
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        long val=(long)Math.pow(10,n)-1;
        String s=Long.toString(val);
        dp=new Integer[s.length()][2][2][1<<10];
        return count(s,0,1,1,0);
    }
    public int count(String s,int idx,int tight,int lz,int mask){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][lz][mask]!=null){
            return dp[idx][tight][lz][mask];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            int nlz=(lz==1 && digit==0) ? 1:0;
            if(lz==1 && digit==0){
                ans+=count(s,idx+1,newt,nlz,mask);
            }
            else{
                if((mask & (1<<digit))!=0){
                    continue;
                }
                ans+=count(s,idx+1,newt,nlz,mask | (1<<digit));
            }
        }
        return dp[idx][tight][lz][mask]=ans;
    }
}