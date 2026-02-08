class Solution {
    public int minDifficulty(int[] job, int d) {
        if(job.length<d){
            return -1;
        }
        int[][] dp=new int[job.length][d+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return jobb(job,0,d,dp);
    }
    public int jobb(int[] job,int idx,int d,int[][] dp){
        if(idx==job.length && d==0){
            return 0;
        }
        if(d<0 || job.length-idx<d){
            return Integer.MAX_VALUE;
        }
        if(dp[idx][d]!=-1){
            return dp[idx][d];
        }

        int ans=Integer.MAX_VALUE;
        int max=0;
        for(int i=idx;i<job.length;i++){
            max=Math.max(job[i],max);
            int next=jobb(job,i+1,d-1,dp);
            if(next!=Integer.MAX_VALUE){
                ans=Math.min(ans,max+next);
            }
        }
        return dp[idx][d]=ans;
    }
}