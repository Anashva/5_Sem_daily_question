class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& res) {
        unordered_map<int,vector<int>> mp;
        for(int i=0;i<res.size();i++){
            int a=res[i][0];
            int b=res[i][1];
            mp[a].push_back(b);
        }
        int ans=(n-mp.size())*2;
        for(auto &[row,seat]:mp){
            bool r=false;
            bool l=false;
            bool m=false;
            for(int val:seat){
                if(val>=2 && val<=5){
                    l=true;
                }
                if(val>=4 && val<=7){
                    m=true;
                }
                if(val>=6 && val<=9){
                    r=true;
                }
            }
            if(!l && !r){
                ans+=2;
            }
            else if(!l || !m || !r){
                ans++;
            }
        }
        return ans;

    }
};