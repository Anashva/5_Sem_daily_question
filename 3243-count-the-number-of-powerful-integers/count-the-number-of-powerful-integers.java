class Solution {
    long[][][] dp;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String s1=Long.toString(start-1);
        String s2=Long.toString(finish);
        dp=new long[s1.length()][s.length()][2];
        for(long[][] a:dp){
            for(long[] b:a){
                Arrays.fill(b,-1);
            }
        }
        long l=count(s1,0,s,0,1,limit);
        dp=new long[s2.length()][s.length()][2];
        for(long[][] a:dp){
            for(long[] b:a){
                Arrays.fill(b,-1);
            }
        }
        long r=count(s2,0,s,0,1,limit);
        return r-l;
    }
    public long count(String s1,int idx1,String s,int idx2,int tight,int limit){
        if(idx1==s1.length()){
            return idx2==s.length() ? 1 :0;
        }
        if(dp[idx1][idx2][tight]!=-1){
            return dp[idx1][idx2][tight];
        }
        int n=s1.length();
        int m=s.length();
        int lb=0;
        int ub=(tight==1) ? Math.min(limit,s1.charAt(idx1)-'0') : limit;
        long ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==s1.charAt(idx1)-'0') ? 1:0;
            if(digit!=s.charAt(idx2)-'0' && idx1==(n-m+idx2)){
                continue;
            }
            int newidx2=(idx1==(n-m+idx2)) ? idx2+1 : idx2;
            ans+=count(s1,idx1+1,s,newidx2,newtight,limit);

        }
        return dp[idx1][idx2][tight]=ans;
    }
}