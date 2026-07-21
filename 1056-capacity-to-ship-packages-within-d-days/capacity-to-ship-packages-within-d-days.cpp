class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int l=0;
        int h=0;
        for(int x:weights){
            l=max(l,x);
            h+=x;
        }
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(poss(weights,mid,days)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    bool poss(vector<int>& arr,int cap,int day){
        int d=1;
        int sum=0;
        for(int x:arr){
            if(sum+x>cap){
                sum=0;
                d++;
            }
            sum+=x;
            if(d>day){
                return false;
            }
        }
        return d<=day;
    }
};