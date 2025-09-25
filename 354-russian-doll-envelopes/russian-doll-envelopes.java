class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int len=1;
        int[][] dp=new int[envelopes.length][2];
        dp[0][0]=envelopes[0][0];
        dp[0][1]=envelopes[0][1];
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][0]>dp[len-1][0] && envelopes[i][1]>dp[len-1][1]){
                dp[len][0]=envelopes[i][0];
                dp[len++][1]=envelopes[i][1];
            }
            else{
                int idx=bs(0,len-1,dp,envelopes[i][1]);
                dp[idx][0]=envelopes[i][0];
                dp[idx][1]=envelopes[i][1];

            }
        } 
        return len;
    }
    public static int bs(int l,int h,int[][] dp,int hight){
        int idx=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(dp[mid][1]>=hight){
                idx=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return idx;
    }
}