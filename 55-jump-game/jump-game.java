class Solution {
    public boolean canJump(int[] nums) {
        int c=1;
        int j=nums.length-1;
        while(j>0){
            if(c>nums[j-1]){
                c++;

            }
            else{
                c=1;
            }
            j--;
        }
        return c==1;
    }
}