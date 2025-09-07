class Solution {
    public int findNumberOfLIS(int[] nums) {
        return LIS(nums);
    }
    public static int LIS(int[] arr){
        int[] lis=new int[arr.length];
        int[] count=new int[arr.length];
        Arrays.fill(lis,1);
        Arrays.fill(count,1);
        for (int i=1;i< lis.length;i++){
            for (int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    if(lis[j]+1>lis[i]){
                    lis[i]=lis[j]+1;
                    count[i]=0;
                    }
                    if(lis[j]+1==lis[i]){
                    count[i]+=count[j];//number of lis ending at that index 
                }
                }
                

            }
        }
        int max=1;
        int ans=0;
        for (int i=1;i<lis.length;i++){
            max=Math.max(max,lis[i]);
        }
        for(int i=0;i<lis.length;i++){
            if(lis[i]==max){
                ans+=count[i];
            }
        }
        return ans;
    }
}