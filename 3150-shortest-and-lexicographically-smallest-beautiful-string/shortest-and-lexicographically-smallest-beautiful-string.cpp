class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        string ans;
        int one=0;
        int end=0;
        int start=0;
        int n=s.size();
        while(end<n){
            if(s[end]=='1'){
                one++;
            }
            while(one>k){
                if(s[start]=='1'){
                    one--;
                }
                start++;
            }
             if (one == k) {
                while(s[start]=='0'){
                    start++;
                }
                string curr = s.substr(start, end - start + 1);
                if (ans.empty() ||
                    curr.size() < ans.size() ||
                    (curr.size() == ans.size() && curr < ans)) {
                    ans = curr;
                }
            }
            end++;
        }
        return ans;
    }
};