class Solution {
public:
    int numberOfSubstrings(string s) {
        return count(s);
    }
    int count(string s){
        int end=0;
        int start=0;
        int ans=0;
        unordered_map<int,int> mp;
        int n=s.length();
        while(end<n){
            mp[s[end]]++;
            while(mp.size()==3){
                ans+=n-end;
                mp[s[start]]--;
                if(mp[s[start]]==0){
                    mp.erase(s[start]);
                }
                 start++;
            }
            end++;
        }
        return ans;
    }
};