class Solution {
    public int minimumAverageDifference(int[] nums) {
        long l=0;
        long r=0;
        long sum=0;
        long min=Long.MAX_VALUE;
        int idx=0;
        for(int i:nums){
            sum+=i;
        }
        for(int i=0;i<nums.length;i++){
            l+=nums[i];
            r=sum-l;
            long left=l/(i+1);
            long right=(nums.length-i)== 1 ? 0:r/(nums.length-i-1);
            long abs=Math.abs(left-right);
            if(abs<min){
                min=abs;
                idx=i;
            }
        }
        return idx;
    }
}