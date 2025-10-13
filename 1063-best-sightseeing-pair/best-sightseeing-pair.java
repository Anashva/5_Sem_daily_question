class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans=Integer.MIN_VALUE;
        int val=values[0];
        for(int i=1;i<values.length;i++){
            int cur=val+values[i]-i;
            ans=Math.max(ans,cur);
            val=Math.max(val,values[i]+i);
        }
        return ans;
    }
}