class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans=0;
        vector<int> freq(256,0);
        int start=0;
        int end=0;
        int n=s.length();
        while(end<n){
            freq[s[end]]++;
            while(freq[s[end]]>1){
                freq[s[start]]--;
                start++;
            }
            ans=max(ans,end-start+1);
            end++;
        }
        return ans;
    }
};