class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // int ans=coin(coins,0,amount);
        // return ans==INT_MAX? -1 :ans;
        if(amount==0){
            return 0;
        }
        vector<int> dp(amount+1,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int c:coins){
                if(i-c>=0){
                    dp[i]=min(dp[i],dp[i-c]+1);
                }
            }
        }
        
        return dp[amount]>amount ? -1: dp[amount];
    }
    // int coin(vector<int> &arr,int idx,int amount){
    //     if(amount==0){
    //         return 0;
    //     }
    //     if(amount<0 || idx>=arr.size()){
    //         return INT_MAX;
    //     }
    //     int ans=INT_MAX;
    //     for(int i=idx;i<arr.size();i++){
    //         if(amount>=arr[i]){
    //             int val=coin(arr,i,amount-arr[i]);
    //             if(val!=INT_MAX){
    //                 ans=min(ans,val+1);
    //             }
    //         }
    //     }
    //     return ans;
    // }
};