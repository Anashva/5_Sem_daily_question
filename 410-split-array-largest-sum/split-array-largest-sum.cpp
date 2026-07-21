class Solution {
public:
    int splitArray(vector<int>& nums, int k) {
        int l=0;
        int h=0;
        for(int x:nums){
            l=max(l,x);
            h+=x;
        }
        int ans=h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(poss(nums,k,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    bool poss(vector<int>& nums,int k,int val){
        int sum=0;
        int c=1;
        for(int x:nums){
            if(sum+x>val){
                c++;
                if(c>k){
                    return false;
                }
                sum=x;
            }
            else{
                sum+=x;
            }
        }
        return true;
    }
};