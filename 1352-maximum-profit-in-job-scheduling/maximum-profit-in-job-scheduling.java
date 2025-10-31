class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] job=new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++){
            job[i][0]=startTime[i];
            job[i][1]=endTime[i];
            job[i][2]=profit[i];
        }
        Arrays.sort(job,(a,b)->(a[0]-b[0]));
        int[] dp=new int[startTime.length];
        Arrays.fill(dp,-1);
        return TD(job,0,dp);
        // return max(job,0);
    }
    public int max(int[][] job,int idx){
        if(idx>=job.length){
            return 0;
        }
        int add=0;
        int skip=0;
        int take=bs(job,job[idx][1]);// for next job whose start >= current job
        add=job[idx][2]+max(job,take);//skip current job
        skip=max(job,idx+1);
        return Math.max(add,skip);
    }
    public int TD(int[][] job,int idx,int[]dp){
        if(idx>=job.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int add=0;
        int skip=0;
        int take=bs(job,job[idx][1]);// for next job whose start >= current job
        add=job[idx][2]+TD(job,take,dp);//skip current job
        skip=TD(job,idx+1,dp);
        return dp[idx]=Math.max(add,skip);
    }

    public int bs(int[][] job,int end){
        int l=0;
        int h=job.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(job[mid][0]<end){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return l;
    }
}