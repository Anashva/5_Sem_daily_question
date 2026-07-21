class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        int l=1;
        int h=0;
        for(int x:nums){
            h=max(h,x);
        }
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(poss(nums,mid,threshold)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    bool poss(vector<int>& nums,int div,int limit){
        int sum=0;
        for(int x:nums){
            sum+=(x+div-1)/div;
            if(sum>limit){
                return false;
            }
        }
        return true;
    }
};