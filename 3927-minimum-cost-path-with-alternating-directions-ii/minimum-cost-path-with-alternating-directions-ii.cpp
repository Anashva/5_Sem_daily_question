class Solution {
public:
    vector<vector<long long>> dp;
    long long minCost(int m, int n, vector<vector<int>>& waitCost) {
        dp.assign(m,vector<long long>(n,-1));
        return cost(m,n,0,0,waitCost)-waitCost[0][0];
    }
    long long cost(int m,int n,int cr,int cc,vector<vector<int>> &waitCost){
        if(cr==m-1 && cc==n-1){
            return (cr+1)*(cc+1);
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        long long right=LLONG_MAX;
        long long down=LLONG_MAX;
        if(cr+1<m){
            right=1L*(cr+1)*(cc+1)+cost(m,n,cr+1,cc,waitCost);
        }
        if(cc+1<n){
            down=1L*(cr+1)*(cc+1)+cost(m,n,cr,cc+1,waitCost);
        }
        return dp[cr][cc]=waitCost[cr][cc]+min(right,down);
    }
};