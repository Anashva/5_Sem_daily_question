class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> freq(128);
        for(int i=0;i<t.length();i++){
            freq[t[i]]++;
        }
        int start=0;
        int end=0;
        int c=0;
        int j=0;
        int mx=INT_MAX;
        while(end<s.size()){
            if(freq[s[end]]-->0){
                c++;
            }
            while(c==t.length()){
                if(mx>(end-start+1)){
                    mx=end-start+1;
                    j=start;
                }
                if(freq[s[start]]++==0){
                    c--;
                }
                start++;
            }
            end++;
        }
        if(mx==INT_MAX){
            return "";
        }
        return s.substr(j,mx);
    }
};