class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] nums=new int[n+m];
        int j=0;
        for(int i=0;i<n;i++){
            nums[j++]=nums1[i];
        }
        for(int i=0;i<m;i++){
            nums[j++]=nums2[i];
        }
        Arrays.sort(nums);
        if((nums.length)%2==0){
            return (double)(nums[nums.length/2]+nums[nums.length/2-1])/2;
        }
        else{
            return (double)nums[nums.length/2];
        }
    }
}