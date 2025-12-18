class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target),last(nums,target)};
    }
    public int last(int[] num,int target){
        int l=0;
        int h=num.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(num[mid]==target){
                ans=mid;
                l=mid+1;
            }
            else if(num[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
    public int first(int[] num,int target){
        int l=0;
        int h=num.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(num[mid]==target){
                ans=mid;
                h=mid-1;
            }
            else if(num[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}