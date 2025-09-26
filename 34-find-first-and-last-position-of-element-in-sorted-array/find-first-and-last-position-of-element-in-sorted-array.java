class Solution {
    public int[] searchRange(int[] arr, int target) {
        // int start=-1;
        // int end=-1;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         if(start==-1){
        //             start=i;
        //         }
        //         end=i;
        //     }
        // }
        // return new int[]{start,end};
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==target){
                int n=mid;
                while(mid>0 && arr[mid-1]==target){
                    mid--;
                }
                while(n<arr.length-1 && arr[n+1]==target){
                    n++;
                }
                return new int[]{mid,n};
            }
            else if(arr[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }

        }
        return new int[]{-1,-1};
   }
}