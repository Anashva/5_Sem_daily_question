class Solution {
public:
    long long dp[20][2][2][343][20][2];
    long long countBalanced(long long low, long long high) {
        low--;
        string l=to_string(low);
        string r=to_string(high);
        memset(dp,-1,sizeof(dp));
        long long r1=solve(r,0,1,1,171,0,1);
        memset(dp,-1,sizeof(dp));
        long long l1=solve(l,0,1,1,171,0,1);
        return r1-l1;
    }
    long long solve(string s,int idx,int tight,int lz,int diff, int cnt,int pos){
        if(idx==s.length()){
            if(lz==1){
                return 0;
            }
            return diff==171 && cnt>=2;
        }
        if(dp[idx][tight][lz][diff][cnt][pos]!=-1){
            return dp[idx][tight][lz][diff][cnt][pos];
        }
        long long ans=0;
        int ub=(tight==1) ? s[idx]-'0' : 9;
        for(int digit=0;digit<=ub;digit++){
            int ntight=(tight==1 && digit==ub);
            int nlz=(lz==1 && digit==0);
            if(lz==1 && digit==0){
                ans+=solve(s,idx+1,ntight,nlz,diff,cnt,pos);
            }
            else{
                int ndiff=diff;
                if(pos){
                    ndiff+=digit;
                }
                else{
                    ndiff-=digit;
                }
                ans+=solve(s,idx+1,ntight,nlz,ndiff,cnt+1,!pos);
            }
        }
        return dp[idx][tight][lz][diff][cnt][pos]=ans;
    }
};