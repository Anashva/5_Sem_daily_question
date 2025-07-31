class Solution {
    public int matrixSum(int[][] nums) {
        for(int[] num:nums){
            Arrays.sort(num);
        }
        int ans=0;
        int n=nums.length;
        int m=nums[0].length;
        for(int i=0;i<m;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                max=Math.max(nums[j][i],max);
            }
            ans+=max;
        }
        return ans;
    }
}