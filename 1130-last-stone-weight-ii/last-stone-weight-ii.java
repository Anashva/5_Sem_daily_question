class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        int[][] dp=new int[stones.length][sum*2+1];//taken 2*sum because index range should in between -sum to sum 
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return stoneDP(stones,0,0,dp,sum);
    }

    public int stone(int[] nums,int idx,int sum){
        if(idx==nums.length){
            return Math.abs(sum);
        }
        int sum1=0;
        int sum2=0;
        sum1=stone(nums,idx+1,sum+nums[idx]);
        sum2=stone(nums,idx+1,sum-nums[idx]);
        int ans=Math.min(sum1,sum2);
        return ans;
    }

    public int stoneDP(int[] nums,int idx,int sum,int[][]dp,int total){
        if(idx==nums.length){
            return Math.abs(sum);
        }
        int t=sum+total;//changing to sum to postive index 
        if(dp[idx][t]!=-1){
            return dp[idx][t];
        }
        int sum1=0;
        int sum2=0;
        sum1=stoneDP(nums,idx+1,sum+nums[idx],dp,total);
        sum2=stoneDP(nums,idx+1,sum-nums[idx],dp,total);
        int ans=Math.min(sum1,sum2);
        return dp[idx][t]=ans;
    }
}