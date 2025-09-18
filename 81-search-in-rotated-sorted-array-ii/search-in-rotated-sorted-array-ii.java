class Solution {
    public boolean search(int[] nums, int target) {
        for(int i:nums){
            if(target==i){
                return true;
            }
        }
        // int left=0;
        // int right=nums.length-1;
        // int start=0;
        // int end=nums.length-1;
        // int mid=0;
        // while(start<=end){
        //     mid=start+(mid-start)/2;
        //     if(nums[mid]==target){
        //         return true;
        //     }
        //     else{
        //         if(nums[left]<nums[mid]){
        //             if(target>=nums[left] && target<nums[mid]){
        //                 end=mid-1;
        //         }
        //             else{
        //                 start=mid+1;
        //         }
        //         }
        //         else if(nums[right]>nums[mid]){
        //             if(target<=nums[right] && target>nums[mid]){
        //                 start=mid+1;
        //             }
        //             else{
        //                 end=mid-1;
        //             }

        //         }
        //         else{
        //             start++;
        //         }
        //     }
        // }
        return false;
    }
}