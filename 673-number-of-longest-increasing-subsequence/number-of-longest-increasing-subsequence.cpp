class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<int> lis(n,1);
        vector<int> dp(n,1);
        int count=lis[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && lis[j]+1>lis[i]){
                    lis[i]=lis[j]+1;
                    dp[i]=dp[j];
                }
                else if(lis[i]==lis[j]+1){
                    dp[i]=dp[i]+dp[j];
                }
            }
            count=max(count,lis[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(count==lis[i]){
                ans+=dp[i];
            }
        }
        return ans;
    }
};