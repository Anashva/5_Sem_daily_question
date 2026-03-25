class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n=arr.length;
        int[] LIS=new int[n];
        int[] LDS=new int[n];
        Arrays.fill(LIS,1);
        Arrays.fill(LDS,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    LIS[i]=Math.max(LIS[j]+1,LIS[i]);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[j]<arr[i]){
                    LDS[i]=Math.max(LDS[j]+1,LDS[i]);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(LIS[i]>1 && LDS[i]>1){
                max=Math.max(max,LIS[i]+LDS[i]-1);
            }
        }
        return n-max;
    }
}