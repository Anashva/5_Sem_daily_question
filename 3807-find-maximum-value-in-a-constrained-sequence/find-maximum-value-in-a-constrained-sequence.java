class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] a=new int[n];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0]=0;
        for(int[] k:restrictions){
            int idx=k[0];
            int val=k[1];
            a[idx]=Math.min(a[idx],val);
        }
        for(int i=1;i<n;i++){
            a[i]=Math.min(a[i],a[i-1]+diff[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            a[i]=Math.min(a[i],a[i+1]+diff[i]);
        }
        int ans=0;
        for(int k:a){
            ans=Math.max(ans,k);
        }
        return ans;
    }
}