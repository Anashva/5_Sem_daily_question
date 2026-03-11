class Solution {
public:
    long long cost(int enc,int flat,int l,int r,vector<int> &pref){
        int one=pref[r+1]-pref[l];
        long long ans;
        if(one==0){
            ans=1LL*flat;
        }
        else{
            ans=1LL*one*enc*(r-l+1);
        }
        if((r-l+1)%2==0){
            int mid=(l+r)/2;
            ans=min(ans,cost(enc,flat,l,mid,pref)+cost(enc,flat,mid+1,r,pref));
        }
        return ans;
    }
    long long minCost(string s, int encCost, int flatCost) {
        int n=s.length();
        vector<int> pref(n+1,0);
        for(int i=0;i<s.length();i++){
            pref[i+1]=pref[i]+(s[i]=='1');
        }
        return cost(encCost,flatCost,0,n-1,pref);
    }
};