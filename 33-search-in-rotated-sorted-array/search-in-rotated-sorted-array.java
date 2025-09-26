class Solution {
    public int search(int[] arr, int target) {
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]==target){
        //         return i;
        //     }
        // }
        // return -1;
        
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>=arr[l]){
                if(arr[l]<=target && target<=arr[mid]){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else if(arr[mid]<=arr[h]){
                if(arr[mid]<=target && target<=arr[h]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}