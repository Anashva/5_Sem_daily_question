class Solution {
    public long mostPoints(int[][] questions) {
        // return point(questions,0);
        long [] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return TD(questions,0,dp);
    }
    public long point(int[][] arr,int i){
        if(i>=arr.length){
            return 0;
        }
        long skip=0;
        long solve=0;
        long ans=0;
        solve=arr[i][0]+point(arr,arr[i][1]+i+1);
        skip=point(arr,i+1);
        return Math.max(solve,skip); 
    }
    public long TD(int[][] arr,int idx,long []dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long skip=0;
        long solve=0;
        solve=arr[idx][0]+TD(arr,arr[idx][1]+idx+1,dp);
        skip=TD(arr,idx+1,dp);
        return dp[idx]=Math.max(solve,skip);
    }
}