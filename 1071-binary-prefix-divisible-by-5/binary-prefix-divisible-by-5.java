class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int prefix=0;
        for(int i=0;i<nums.length;i++){
            prefix=((prefix << 1)+nums[i])%5;
            if(prefix==0){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}