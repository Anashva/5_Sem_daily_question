class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int k=prices[0];
        for(int i=1;i<prices.length;i++){
            ans=Math.max(ans,prices[i]-k);
            if(prices[i]<k){
                k=prices[i];
            }
        }
        return ans;
        
    }
}