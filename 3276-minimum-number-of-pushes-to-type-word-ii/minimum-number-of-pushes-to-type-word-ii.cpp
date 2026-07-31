class Solution {
public:
    int minimumPushes(string word) {
        vector<int> freq(26);
        for(char ch:word){
            freq[ch-'a']++;
        }
        sort(freq.begin(),freq.end(),greater<int>());
        int total=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                break;
            }
            total+=(i/8+1)*freq[i];
        }
        return total;
    }
};