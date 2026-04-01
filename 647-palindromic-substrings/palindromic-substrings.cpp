class Solution {
public:
    int countSubstrings(string s) {
        bool dp[1001][1001];
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s[i]==s[j]){
                    if(j-i<=2){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
};