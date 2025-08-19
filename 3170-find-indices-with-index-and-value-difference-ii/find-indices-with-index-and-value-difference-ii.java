class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int i=0;
        int j=indexDifference;
        int minid=0;
        int maxid=0;
        while(j<nums.length){
            i=j-indexDifference;
            if(nums[i]<nums[minid]){
                minid=i;
            }
            if(nums[i]>nums[maxid]){
                maxid=i;
            }
            if(Math.abs(nums[j]-nums[minid])>=valueDifference){
                return new int[]{minid,j};
            }
            if(Math.abs(nums[j]-nums[maxid])>=valueDifference){
                return new int[]{maxid,j};
            }
            j++;
        }
        return new int[]{-1,-1};
    }
}