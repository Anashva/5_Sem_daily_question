class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int ans=0;
        while(i<j){
            int k=nums[i]+nums[j];
            ans=Math.max(k,ans);
            i++;
            j--;
        }
        return ans;
    }
}