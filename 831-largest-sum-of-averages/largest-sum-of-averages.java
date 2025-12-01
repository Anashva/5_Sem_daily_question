class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        double[][] dp=new double[nums.length][k+1];
        for(double[] a:dp){
            Arrays.fill(a,-1.0);
        }
        return average(nums,0,k,prefix,dp);

    }
    public double average(int[] nums,int idx,int k,int[] prefix,double[][]dp){
        if(idx>=nums.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(k==1){
            double sum = prefix[nums.length - 1] - (idx == 0 ? 0 : prefix[idx - 1]);
            return dp[idx][k] = sum / (nums.length - idx);
        }
        if(dp[idx][k]!=-1.0){
            return dp[idx][k];
        }
        for(int i=idx;i<=nums.length-k;i++){
            int sum=prefix[i]-(idx ==0 ? 0:prefix[idx-1]);
            dp[idx][k]=Math.max(dp[idx][k],((double)(sum)/(i-idx+1))+average(nums,i+1,k-1,prefix,dp));
        }
        return dp[idx][k];
    }
}