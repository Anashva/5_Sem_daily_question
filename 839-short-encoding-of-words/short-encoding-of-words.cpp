class Solution {
public:
    int minimumLengthEncoding(vector<string>& words){
        set<string> st;
        for(auto &e :words){
            st.insert(e);
        }
        for(int i=0;i<words.size();i++){
            string s=words[i];
            for(int j=1;j<s.length();j++){
                st.erase(s.substr(j));
            }
        }
        int ans=0;
        for(auto e:st){
            ans+=e.length()+1;
        }
        return ans;
    }
};