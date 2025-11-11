class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=ages[i];
            arr[i][1]=scores[i];
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int[][] dp=new int[scores.length][scores.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return max(arr,0,dp,-1);

    }
    public int max(int[][] arr,int idx,int[][] dp,int j){
            if(idx>=arr.length){
                return 0;
            }
            if(dp[j+1][idx]!=-1){
                return dp[j+1][idx];
            }
            int pick=0;
            if(j==-1 || arr[j][1]<=arr[idx][1]){//maximizing our score by checking that agr prev curr wala chhota rha apne prev se to skip kr denge beacuse of conflict
                pick=arr[idx][1]+max(arr,idx+1,dp,idx);
            }
            int npick=max(arr,idx+1,dp,j);
            return dp[j+1][idx]=Math.max(pick,npick);
      }
}