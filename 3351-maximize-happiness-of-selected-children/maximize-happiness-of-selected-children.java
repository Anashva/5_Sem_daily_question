class Solution {
    public long maximumHappinessSum(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr=new int[nums.length];
        int i=0;
        for(int j=nums.length-1;j>=0;j--){
            arr[i]=nums[j];
            i++;
        }
        long ans=0;
        int c=0;
        for(int j=0;j<k;j++){
            ans+=Math.max(arr[j]-c,0);
            c++;
        }
        return ans;
    }
}