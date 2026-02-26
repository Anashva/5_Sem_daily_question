class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n=s.length();
        int freq[256]={0};
        int start=0;
        int end=0;
        int ans=0;
        while(end<n){
            freq[s[end]]++;
            while(freq[s[end]]>1){
                freq[s[start]]--;
                start++;
            }
            ans=max(end-start+1,ans);
            end++;
        }
        return ans;
    }
};