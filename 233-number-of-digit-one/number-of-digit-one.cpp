class Solution {
public:
    int countDigitOne(int n) {
        string s=to_string(n);
        int dp[11][2][10];
        for(int i=0;i<11;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<10;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return count(s,0,1,0,dp);
    }
    int count(string s,int idx,int tight,int cnt1,int dp[11][2][10]){
        if(idx==s.length()){
            return cnt1;
        }
        if(dp[idx][tight][cnt1]!=-1){
            return dp[idx][tight][cnt1];
        }
        int lb=0;
        int ub=(tight==1) ? s[idx] -'0' :9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            int cnt=(digit==1) ? cnt1+1 : cnt1;
            ans+=count(s,idx+1,newt,cnt,dp);
        }
        return dp[idx][tight][cnt1]=ans;
    }
};