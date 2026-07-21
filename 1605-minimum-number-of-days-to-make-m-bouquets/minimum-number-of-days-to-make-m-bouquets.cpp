class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        if((long long)m*k>bloomDay.size()){
            return -1;
        }
        int l=INT_MAX;
        int h=INT_MIN;
        for(int x:bloomDay){
            l=min(l,x);
            h=max(h,x);
        }
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(poss(bloomDay,m,k,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    bool poss(vector<int>& arr,int m,int k,int day){
        int c=0;
        int bckt=0;
        for(int x:arr){
            if(x<=day){
                c++;
                if(c==k){
                    bckt++;
                    c=0;
                }
            }
            else{
                c=0;
            }
        }
        return bckt>=m;
    }
};