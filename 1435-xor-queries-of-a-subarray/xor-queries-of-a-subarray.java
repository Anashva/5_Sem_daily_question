class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pref=new int[arr.length];
        pref[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pref[i]=pref[i-1] ^ arr[i];
        }
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] q:queries){
            int l=q[0];
            int r=q[1];
            if(l==0){
                ans[i++]=pref[r];
            }
            else{
                ans[i++]=pref[r]^pref[l-1];
            }
        }
        return ans;
    }
}