class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        int ans=0;
        while(i<nums.length){
            while(nums[i]>(long)nums[j]*k){
                j++;
            }
            ans=Math.max(ans,i-j+1);
            i++;
            
        }
        return nums.length-ans;
    }
}