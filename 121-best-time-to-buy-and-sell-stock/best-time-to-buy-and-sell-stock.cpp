class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // int ans=0;
        // for(int i=0;i<prices.size();i++){
        //     for(int j=i+1;j<prices.size();j++){
        //         ans=max(ans,prices[j]-prices[i]);
        //     }
        // }
        // return ans;



        int ans=0;
        int price=prices[0];
        for(int i=1;i<prices.size();i++){
            ans=max(ans,prices[i]-price);
            if(price>prices[i]){
                price=prices[i];
            }
        }
        return ans;
    }
};