class Solution {
public:
    int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        vector<bool> prime(n,true);
        prime[0]=prime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=2;j*i<n;j++){
                    prime[i*j]=false;
                }
            }
        }
        int c=0;
        for(int i=2;i<n;i++){
            if(prime[i]){
                c++;
            }
        }
        return c;
    }
};