class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int k) {
        if(hand.size()%k){
            return false;
        }
        sort(hand.begin(),hand.end());
        unordered_map<int,int> mp;
        for(int x:hand){
            mp[x]++;
        }
        for(int x:hand){
            if(mp[x]>0){
                for(int i=0;i<k;i++){
                    if(!mp.count(x+i) || mp[x+i]<=0){
                        return false;
                    }
                    mp[i+x]--;
                }
            }
        }
        return true;
    }
};