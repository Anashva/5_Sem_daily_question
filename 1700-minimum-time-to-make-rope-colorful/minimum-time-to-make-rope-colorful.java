class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        int sum=0;
        int max=0;
        for(int i=0;i<colors.length();i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                ans+=sum-max;
                sum=0;
                max=0;
            }
                max=Math.max(neededTime[i],max);
                sum+=neededTime[i];
            
        }
        ans+=sum-max;
        return ans;
    }
}