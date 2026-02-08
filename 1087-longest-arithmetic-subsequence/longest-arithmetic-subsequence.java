class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=1;
        HashMap<Integer,Integer>[] dp=new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                int prev=dp[j].getOrDefault(diff,1);
                int curr=dp[i].getOrDefault(diff,0);
                dp[i].put(diff,Math.max(prev+1,curr));
                ans=Math.max(ans,dp[i].get(diff));
            }
        }
        return ans;
    }
}