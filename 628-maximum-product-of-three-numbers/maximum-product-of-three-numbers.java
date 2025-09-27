class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int p=nums[n-1]*nums[n-2]*nums[n-3];
        int s=nums[0]*nums[1]*nums[n-1];
        return Math.max(p,s);
    }
}