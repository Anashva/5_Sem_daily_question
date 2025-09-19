class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int h=nums[nums.length-1]-nums[0];
        while(l<h){
            int mid=l+(h-l)/2;
            int c=possible(nums,mid);
            if(c<k){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return l;
    }
    public int possible(int[] nums,int mid){
        int c=0;
        int start=0;
        int end=0;
        while(end<nums.length){
            while(nums[end]-nums[start]>mid){
                start++;
            }
            c+=end-start;
            end++;
        }
        return c;
    }
}