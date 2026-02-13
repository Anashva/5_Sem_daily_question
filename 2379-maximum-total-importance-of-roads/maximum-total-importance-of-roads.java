class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] in=new int[n];
        for(int[] e:roads){
            in[e[0]]++;
            in[e[1]]++;
        }
        Arrays.sort(in);
        long val=1;
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=(long)in[i]*val;
            val++;
        }
        return ans;
    }
}