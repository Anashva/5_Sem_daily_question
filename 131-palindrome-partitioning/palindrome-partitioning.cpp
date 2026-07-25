class Solution {
public:
    vector<vector<string>> ans;
    vector<string> ll;
    vector<vector<string>> partition(string s) {
        solve(s,0);
        return ans;
    }
    void solve(string s,int idx){
        if(idx==s.length()){
            ans.push_back(ll);
            return;
        }
        for(int i=idx;i<=s.length();i++){
            string t=s.substr(idx,i-idx+1);
            if(pall(t)){
                ll.push_back(t);
                solve(s,i+1);
                ll.pop_back();
            }
        }
    }
    bool pall(string s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};