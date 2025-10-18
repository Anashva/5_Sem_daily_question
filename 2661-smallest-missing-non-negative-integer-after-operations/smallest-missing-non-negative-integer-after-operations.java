class Solution {
    public int findSmallestInteger(int[] nums, int v) {
        int[]ans=new int[v];
        for(int i:nums){
            int x=((i%v)+v)%v;
            ans[x]++;
        }
        int c=0;
        while(ans[c%v]-->0){
            c++;
        }
        return c;
    }
}