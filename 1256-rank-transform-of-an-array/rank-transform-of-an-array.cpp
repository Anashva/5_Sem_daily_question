class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int> num(arr);
        sort(num.begin(),num.end());
        unordered_map<int,int> mp;
        for(int i=0;i<arr.size();i++){
            if(!mp.count(num[i])){
                mp[num[i]]=mp.size()+1;
            }
        }
        for(int i=0;i<arr.size();i++){
            arr[i]=mp[arr[i]];
        }
        return arr;
    }
};