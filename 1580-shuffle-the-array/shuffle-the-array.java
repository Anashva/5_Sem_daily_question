class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int i=0;
        int j=n;
        int idx=0;
        while(i<n){
            ans[idx++]=nums[i];
            ans[idx++]=nums[j++];
            i++;
        }
        return ans;
    }
}