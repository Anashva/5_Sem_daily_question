class Solution {
public:
    vector<vector<int>> dp; 
    bool winnerSquareGame(int n) {
        dp.assign(n + 1, vector<int>(2, -1));
        return solve(n, 1);
    }

    bool solve(int n, int turn) {
        if(n == 0){
            return false;
        }
        int x=sqrt(n);
        if(dp[n][turn]!=-1){
            return dp[n][turn];
        }
        if(x * x == n){
            return true;
        }

        if (turn) {
            for (int i = 1; i * i <= n; i++) {
                if (!solve(n - i * i, 0)){//previus move of alice is winning
                    return dp[n][turn]=true;
                }
            }
            return dp[n][turn]=false;
        } 
        else {
            for (int i = 1; i * i <= n; i++) {
                if (!solve(n - i * i, 1))
                    return dp[n][turn]=true;
            }
            return dp[n][turn]=false;
        }
    }
};