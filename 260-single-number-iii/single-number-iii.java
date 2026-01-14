class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int mask=xor&(-1*xor);//(xor&(~(xor-1)))
        int a=0;
        for(int i=0;i<nums.length;i++){
            if((mask & nums[i])!=0){
                a=a^nums[i];
            }
        }
        int b=xor^a;
        return new int[]{a,b};
    }
}