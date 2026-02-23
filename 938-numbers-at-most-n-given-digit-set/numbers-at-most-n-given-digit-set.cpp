class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        string s=to_string(n);
        unordered_set<int> st;
        for(auto &ll :digits){
            st.insert(stoi(ll));
        }
        int dp[12][2][2];
        for(int i=0;i<12;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return count(s,st,dp,1,1,0);
    }
    int count(string s,unordered_set<int> st,int dp[12][2][2],int tight,int lz,int idx){
        if(idx==s.length()){
            return lz==0 ? 1:0;
        }
        if(dp[idx][tight][lz]!=-1){
            return dp[idx][tight][lz];
        }
        int ans=0;
        int ub=(tight==1) ? s[idx]-'0' : 9;
        for(int digit=0;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0){
                ans+=count(s,st,dp,newt,lz,idx+1);
            }
            else{
                if(st.count(digit)){
                    ans+=count(s,st,dp,newt,0,idx+1);
                }
                
            }
        }
        return dp[idx][tight][lz]=ans;
    }

};