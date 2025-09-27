class Solution {
    public boolean search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]==nums[l] && nums[mid]==nums[h]){
                l++;
                h--;
            }
            
            else if(nums[mid]>=nums[l]){
                if(nums[l]<=target && target<=nums[mid]){
                    h=mid;
                }
                else{
                    l=mid+1;
                }
            }
            else if(nums[mid]<=nums[h]){
                if(nums[mid]<=target && target<=nums[h]){
                    l=mid+1;
                }
                else{
                    h=mid;
                }
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