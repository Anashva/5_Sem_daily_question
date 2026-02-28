class Solution {
public:
    int concatenatedBinary(int n) {
        int mod=1000000007;
        long long  ans=0;
        int bit=0;
        for(int i=1;i<=n;i++){
            if((i & (i-1))==0){
                bit++;
            }
            ans=((ans<<bit)+i)%mod;
        }
        return ans;
    }
};