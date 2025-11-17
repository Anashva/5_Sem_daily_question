class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int a=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(a==-1){
                    a=i;
                }
                else{
                    if(i-a-1<k){
                        return false;
                    }
                    a=i;
                }
            }
        }
        return true;
    }
}