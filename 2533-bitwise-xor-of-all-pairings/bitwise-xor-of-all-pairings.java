class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            ans^=nums1[i];
        }
        int sum=0;
        for(int i=0;i<nums2.length;i++){
            sum^=nums2[i];
        }
        int xor=0;
        if(n%2!=0){
            xor^=sum;
        }
        if(m%2!=0){
            xor^=ans;
        }
        return xor;
    }
}