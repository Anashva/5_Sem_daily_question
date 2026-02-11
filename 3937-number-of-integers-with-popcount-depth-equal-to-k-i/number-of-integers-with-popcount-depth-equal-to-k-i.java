class Solution {
    Long[][][][] dp;
    public long popcountDepth(long n, int k) {
        if(k==0){
            return n>=1 ? 1:0;
        }
        String s=Long.toBinaryString(n);
        dp=new Long[s.length()][2][2][s.length()+1];
        long ans=count(s,0,1,1,0,k);
        if (k == 1 && n >= 1) {
            ans -= 1;
        }
        return ans;
    }
    public long count(String s,int idx,int tight,int lz,int cnt,int k){
        if(idx==s.length()){
            if(lz==1){
                return 0;
            }
            return check(cnt,k-1) ? 1:0;
        }
        if(dp[idx][tight][lz][cnt]!=null){
            return dp[idx][tight][lz][cnt];
        }
        int lb=0;
        int ub=(tight==1) ?s.charAt(idx)-'0':1;
        long ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            int newlz=(lz==1 && digit==0)? 1:0;
            int ncnt=(digit==1) ? cnt+1 : cnt;
            ans+=count(s,idx+1,newt,newlz,ncnt,k);
        }
        return dp[idx][tight][lz][cnt]=ans;
    }
    public boolean check(int n,int k){
        int c=0;
        while(n>1){
            c++;
            n=setbit(n);
        }
        return n==1 && c==k;
    }
    public int setbit(int n){
        int c=0;
        while(n>0){
            n=n & (n-1);
            c++;
        }
        return c;
    }
}