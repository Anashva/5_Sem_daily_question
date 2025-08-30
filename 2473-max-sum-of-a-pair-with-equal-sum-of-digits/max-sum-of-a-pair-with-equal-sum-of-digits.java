class Solution {
    public int maximumSum(int[] nums) {
        int[][] sum=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            sum[i][0]=nums[i];
            int n=nums[i];
            int d=0;
            while(n>0){
                int r=n%10;
                d+=r;
                n/=10;
            }
            sum[i][1]=d;

        }
        int ans=-1;
        Arrays.sort(sum,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        for(int i=1;i<sum.length;i++){
            if(sum[i][1]==sum[i-1][1]){
                ans=Math.max(ans,sum[i][0]+sum[i-1][0]);
            }
        }
        return ans;
    }
}