class Solution {
public:
    const int MOD=1e9+7;
    int countGoodNumbers(long long n) {
        // solve(0,n);
        
        // long long ans = 1;
        // for (long long i = 0; i < n; i++) {
        //     if (i % 2 == 0){
        //         ans = (ans * 5) % MOD;
        //     }
        //     else{
        //         ans = (ans * 4) % MOD;
        //     }
        // }

        // return ans;
        long long even=(n+1)/2;
        long long odd=(n)/2;
        return (powr(5,even)*powr(4,odd))%MOD;
    }
    long long powr(long long a,long long b){
        long long ans=1;
        while(b>0){
            if(b & 1){
                ans=(ans*a)%MOD;
            }
            b>>=1;
            a=(a*a)%MOD;
        }
        return ans;
    }
    void solve(int idx,int n){
        if(idx==n){
            // ans=(ans+1)%mod;
            return;
        }
        if(idx%2==0){
            solve(idx+1,n);
            solve(idx+1,n);
            solve(idx+1,n); 
            solve(idx+1,n);
            solve(idx+1,n);
        }
        else{
            solve(idx+1,n);
            solve(idx+1,n);
            solve(idx+1,n); 
            solve(idx+1,n);
        }
    }
};