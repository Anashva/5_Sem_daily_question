class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='('){
                c++;
                if(c>1){
                    ans.push_back('(');
                }
            }
            else {
                c--;
                if(c>0){
                    ans.push_back(')');
                }
            }
        }
        return ans;
    }
};