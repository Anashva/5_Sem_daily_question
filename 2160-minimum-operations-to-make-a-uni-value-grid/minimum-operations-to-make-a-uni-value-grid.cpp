class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        int n=grid.size();
        int m=grid[0].size();
        int rem=grid[0][0]%x;
        vector<int> nums;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]%x!=rem){
                    return -1;
                }
                nums.push_back(grid[i][j]);
            }
        }
        sort(nums.begin(),nums.end());
        int len=n*m;
        int mid=(len%2==0) ? (len/2-1) : len/2;
        int val=nums[mid];
        int ans=0;
        for(int nm:nums){
            ans+=(abs(nm-val))/x;
        }
        return ans;
    }
};