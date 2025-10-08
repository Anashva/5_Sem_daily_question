class Solution {
    public long minCost(int[] nums, int[] cost) {
        int[][] arr=new int[nums.length][2];
        long total=0;
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=cost[i];
            total+=cost[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        long sum=0;
        int ele=0;
        for(int i=0;i<nums.length;i++){
            sum+=arr[i][1];
            if(sum*2>=total){
                ele=arr[i][0];
                break;
            }
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=(long)Math.abs(arr[i][0]-ele)*arr[i][1];
        }
        return ans;
    }
}