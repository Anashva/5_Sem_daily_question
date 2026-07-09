class Solution {
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> prefix(n);
        prefix[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                prefix[i]=prefix[i-1];
            }
            else{
                prefix[i]=prefix[i-1]+1;
            }
        }
        vector<bool> ans;
        for(auto &e:queries){
            int l=e[0];
            int r=e[1];
            if(prefix[l]==prefix[r]){
                ans.push_back(true);
            }
            else{
                ans.push_back(false);
            }
        }
        return ans;
    }
};