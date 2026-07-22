class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char,int> mp;
        for(char ch:s){
            mp[ch]++;
        }
        vector<pair<char,int>> arr(mp.begin(),mp.end());
        sort(arr.begin(),arr.end(),[](auto &p1,auto &p2){
           if(p1.second!=p2.second){
            return p1.second>p2.second;
           }
            return p1.first<p2.first;
        });
        string ans;
        for(auto &e:arr){
            for(int i=0;i<e.second;i++){
                ans.push_back(e.first);
            }
        }
        return ans;
    }
};