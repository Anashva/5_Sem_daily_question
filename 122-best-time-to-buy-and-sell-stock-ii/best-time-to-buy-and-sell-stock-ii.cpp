class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // return profit(0,prices,1);
        int ans=0;
        vector<vector<int>> dp(prices.size()+1,vector<int>(2,0));
        for(int i=prices.size()-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j]=max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    dp[i][j]=max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    int profit(int idx,vector<int> &arr,int turn){
        if(idx==arr.size()){
            return 0;
        }

        int buy=0;
        int sell=0;
        if(turn){
            buy=max(-arr[idx]+profit(idx+1,arr,0),profit(idx+1,arr,1));
        }
        else{
            sell=max(arr[idx]+profit(idx+1,arr,1),profit(idx+1,arr,0));
        }
        return max(buy,sell);
    }
};