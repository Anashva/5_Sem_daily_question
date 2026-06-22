class Solution {
public:
    string shortestCommonSupersequence(string s1, string s2) {
        int n=s1.size();
        int m=s2.size();



        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        string ans="";
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(s1[i-1]==s2[j-1]){
                ans+=s1[i-1];
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans+=s1[i-1];
                i--;
            }
            else{
                ans+=s2[j-1];
                j--;
            }
        }
        while(i>0){
            ans+=s1[i-1];
            i--;
        }
        while(j>0){
            ans+=s2[j-1];
            j--;
        }
        reverse(ans.begin(),ans.end());
        return ans;

    }
    string solve(string &s1, string &s2, int i, int j) {

        if (i == s1.size())
            return s2.substr(j);

        if (j == s2.size())
            return s1.substr(i);

        if (s1[i] == s2[j]) {
            return s1[i] + solve(s1, s2, i + 1, j + 1);
        }

        string op1 = s1[i] + solve(s1, s2, i + 1, j);
        string op2 = s2[j] + solve(s1, s2, i, j + 1);

        return (op1.size() <= op2.size()) ? op1 : op2;
    }
};