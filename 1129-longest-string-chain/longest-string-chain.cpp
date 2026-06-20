class Solution {
public:
    static bool compare(string a,string b){
        return a.length()<b.length();
    }
    int longestStrChain(vector<string>& words) {
        int ans=0;
        sort(words.begin(),words.end(),compare);
        unordered_map<string,int> mp;
        for(string t:words){
            mp[t]=1;
            for(int i=0;i<t.length();i++){
                string s=t;
                s.erase(i,1);
                if(mp.count(s) && mp[s]+1>mp[t]){
                    mp[t]=mp[s]+1;
                }
            }
            ans=max(ans,mp[t]);
        }
        return ans;
    }
};