class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        string sb;
        for(string s:words){
            int sum=0;
            for(char ch:s){
                sum+=weights[ch-'a'];
            }
            int mod=sum%26;
            char ch=(char)('z'- mod);
            sb.push_back(ch);
        }
        return sb;
    }
};