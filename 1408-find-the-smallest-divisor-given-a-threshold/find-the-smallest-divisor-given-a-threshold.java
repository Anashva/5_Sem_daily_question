class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int h=0;
        int l=1;
        for(int i:nums){
            h=Math.max(h,i);
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(possible(nums,threshold,mid)){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean possible(int[] nums,int thresh,int mid){
        int sum=0;
        for(int i:nums){
            sum+=(i+mid-1)/mid;
            if(sum>thresh){
                return false;
            }
        }
        return true;
    }
}