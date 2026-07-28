class Solution {
public:
    string smallestPalindrome(string s) {
        vector<int> freq(26);
        for(char ch:s){
            freq[ch-'a']++;
        }
        string t="";
        char mid='\0';
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                char ch='a'+i;
                int c=freq[i]/2;
                while(c--){
                    t.push_back(ch);
                }
                if(freq[i]%2){
                    mid=ch;
                }
            }
        }
        string ans=t;
        if(mid!='\0'){
            ans.push_back(mid);
        }
        reverse(t.begin(), t.end());
        ans += t;
        return ans;
    }
};