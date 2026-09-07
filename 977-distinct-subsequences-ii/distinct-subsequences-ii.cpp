class Solution {
public:
    int mod=1000000007;
    int distinctSubseqII(string s) {
        vector<long long> dp(s.size(),-1);
        return count(s,0,dp);
    }
    long long count(string &s,int idx,vector<long long> &dp){
        if(s.size()<=idx){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        long long ans=0;
        unordered_set<int> st;
        for(int i=idx;i<s.size();i++){
            if(!st.count(s[i])){
                st.insert(s[i]);
                ans=(ans+1+count(s,i+1,dp))%mod;
                // st.erase(s[i]);
            }
        }
        return dp[idx]=ans;
    }
};