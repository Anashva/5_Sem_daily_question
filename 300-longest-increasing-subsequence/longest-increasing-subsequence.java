class Solution {
    public int lengthOfLIS(int[] nums) {
        // return LIS(nums);
        return lis(nums);
    }
    public static int lis(int[] arr){
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        int len=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>dp[len-1]){
                dp[len]=arr[i];
                len++;
            }
            else{
                int idx=bs(dp,0,len,arr[i]);
                dp[idx]=arr[i];
            }
        }
        return len;
    }
    public static int bs(int[] dp,int l,int h,int item){
        int idx=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(dp[mid]>=item){
                idx=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return idx;
    }


    public static int LIS(int[] arr){
        int[] lis=new int[arr.length];
// har element khud ka apna lis hoga
        Arrays.fill(lis,1);
        for (int i=1;i< lis.length;i++){
            for (int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    int l=lis[j];
                    lis[i]=Math.max(lis[i],l+1);
                }
            }
        }
        int max=lis[0];
        for (int i=1;i<lis.length;i++){
            max=Math.max(max,lis[i]);
        }
        return max;
    }

}