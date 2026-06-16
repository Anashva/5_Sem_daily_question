class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sum(nums,target,0);
    }
    public static int sum(int[] nums,int target,int idx){
        if(target==0 && idx==nums.length){
            return 1;
        }
        if(target!=0 && idx==nums.length){
            return 0;
        }
        int c=0;
        c+=sum(nums,target+nums[idx],idx+1);
        c+=sum(nums,target-nums[idx],idx+1);
    
        return c;
    }
}