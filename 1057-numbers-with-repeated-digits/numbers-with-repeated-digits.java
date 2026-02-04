class Solution {
    int[][][][][] dp;
    public int numDupDigitsAtMostN(int n) {
        String s=Integer.toString(n);
        dp=new int[11][2][2][2][1024];
        for(int[][][][] a:dp){
            for(int[][][] b:a){
                for(int[][] c:b){
                    for(int[] d:c){
                        Arrays.fill(d,-1);
                    }
                }
            }
        }
        return count(s,0,1,0,0,1);
    }
    public int count(String s,int idx,int tight,int rept,int mask,int lz){
        if(idx==s.length()){
            return rept==1 ? 1: 0;
        }
        if(dp[idx][tight][rept][lz][mask]!=-1){
            return dp[idx][tight][rept][lz][mask];
        }
        int lb=0;
        int ub=tight==1 ? s.charAt(idx)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0){
                ans+=count(s,idx+1,newt,rept,mask,lz);
            }
            else{
                int isused=(1 & (mask>>digit));
                int newmask=(mask | (1<<digit));
                int newrp=(rept==1 || isused==1) ? 1 :0;
                ans+=count(s,idx+1,newt,newrp,newmask,(lz==1 && digit==0) ? 1 :0);
            }
        }
        return dp[idx][tight][rept][lz][mask]=ans;
    }
}