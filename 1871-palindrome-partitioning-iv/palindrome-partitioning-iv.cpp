class Solution {
public:
    bool dp[2001][2001];
    int dp1[2001][4];
    bool checkPartitioning(string s) {
        int n=s.length();
        for(int i=0;i<2001;i++){
            for(int j=0;j<4;j++){
                dp1[i][j]=-1;
            }
        }
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
        return check(s,0,0);
    }
    bool check(string &s,int i,int count){
        if(count>3){
            return false;
        }
        if(i==s.length()){
            return count==3;
        }
        if(dp1[i][count]!=-1){
            return dp1[i][count];
        }
        for(int k=i;k<s.length();k++){
            if(dp[i][k]){
                if(check(s,k+1,count+1)){
                    return dp1[i][count]=1;
                }
            }
        }
        return dp1[i][count]=0;
    }
};