class Solution {
public:
    vector<string> ll;
    vector<string> letterCombinations(string digits) {
        string val[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        string t="";
        solve(digits,0,t,val);
        return ll;
    }
    void solve(string &s,int idx,string ans,string val[]){
        if(idx==s.length()){
            ll.push_back(ans);
            return;
        }
        int d=s[idx]-'0';
        for(int i=0;i<val[d].size();i++){
            solve(s,idx+1,ans+val[d][i],val);
        }
    }
};