class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int l=0;
        int h=nums1.length;
        int total=nums1.length+nums2.length;
        int hf=(total+1)/2;
        while(l<=h){
            int al=(l+h)/2;
            int bl=hf-al;

            int maxal=(al==0) ? Integer.MIN_VALUE:nums1[al-1];
            int minal=(al==nums1.length) ? Integer.MAX_VALUE :nums1[al];
            int maxbl=(bl==0) ? Integer.MIN_VALUE : nums2[bl-1];
            int minbl=(bl==nums2.length) ? Integer.MAX_VALUE:nums2[bl];

            if(maxal<=minbl && maxbl<=minal){
                double ans=0;
                if(total%2==0){
                    ans=(Math.max(maxal,maxbl)+Math.min(minbl,minal))/2.0;
                }
                else{
                    ans=Math.max(maxal,maxbl)/1.0;
                }
                return ans;
            }
            else if(maxbl>minal){
                l=al+1;
            }
            else {
                h=al-1;
            }
        }
        return 0.0;
    }
}