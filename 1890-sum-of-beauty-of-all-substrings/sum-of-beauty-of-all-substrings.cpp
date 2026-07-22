class Solution {
public:
    int beautySum(string s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            vector<int> freq(26);
            for(int j=i;j<s.length();j++){
                freq[s[j]-'a']++;
                int mn=INT_MAX;
                int mx=0;
                for(int x:freq){
                    if(x>0){
                        mn=min(mn,x);
                        mx=max(mx,x);
                    }
                }
                ans+=mx-mn;
            }
        }
        return ans;
    }
};