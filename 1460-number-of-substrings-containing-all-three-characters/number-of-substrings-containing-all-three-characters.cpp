class Solution {
public:
    int numberOfSubstrings(string s) {
        return count(s);
    }
    int count(string s){
        int end=0;
        int start=0;
        int ans=0;
        vector<int> freq(3,0);
        int n=s.length();
        while(end<n){
            freq[s[end]-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans+=n-end;
                freq[s[start]-'a']--;
                 start++;
            }
            end++;
        }
        return ans;
    }
};