class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        int n=nums.size();
        vector<int> pair(2048);
        vector<int> trip(2048);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                pair[nums[i] ^ nums[j]]=1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<2048;j++){
                if(pair[j]==1){
                    trip[nums[i] ^ j]=1;
                }
            }
        }
        int c=0;
        for(int x:trip){
            if(x==1){
                c++;
            }
        }
        return c;
    }
};