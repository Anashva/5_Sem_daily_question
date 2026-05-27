class Solution {
public:
    int numberOfSpecialChars(string word) {
        vector<int> upper(26,-1);
        vector<int> lower(26,-1);
        for(int i=0;i<word.length();i++){
            char ch=word[i];
            if(isupper(ch)){
                if(upper[ch-'A']==-1){
                    upper[ch-'A']=i;
                }
            }
            else if(islower(ch)){
                lower[ch-'a']=i;
            }
        }

        int ans=0;
        for(int i=0;i<26;i++){
            if(lower[i]==-1 || upper[i]==-1){
                continue;
            }
            else if(lower[i]<upper[i]){
                ans++;
            }
        }
        return ans;
    }
};