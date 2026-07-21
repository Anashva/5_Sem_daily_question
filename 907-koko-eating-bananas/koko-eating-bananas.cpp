class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int l=1;
        int hi=0;
        for(int x:piles){
            hi=max(hi,x);
        }
        int ans=hi;
        while(l<=hi){
            int mid=l+(hi-l)/2;
            if(poss(piles,mid,h)){
                ans=mid;
                hi=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    bool poss(vector<int>& piles,int k,int h){
        long long thr = 0;
        for(int x:piles){
            thr+=(long long)(x+k-1)/(long long)k;
        }
        return thr<=h;
    }
};