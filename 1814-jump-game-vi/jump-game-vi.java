class Solution {
    public int maxResult(int[] nums, int k) {
        return max(nums,k);
    }
    public int max(int[] nums,int k){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{dp[0],0});
        for(int i=1;i<n;i++){
            while(pq.peek()[1]<i-k){
                pq.poll();
            }
            dp[i]=nums[i]+pq.peek()[0];
            pq.add(new int[]{dp[i],i});
        }
        return dp[n-1];
    }
}