class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        Arrays.fill(arr1,1);
        Arrays.fill(arr2,1);
        for(int i=1;i<arr1.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    arr1[i]=Math.max(arr1[i],arr2[j]+1);
                }
                if(nums[i]<nums[j]){
                    arr2[i]=Math.max(arr2[i],arr1[j]+1);
                }
            }
        }
        return Math.max(arr1[arr1.length-1],arr2[arr2.length-1]);
    }
}