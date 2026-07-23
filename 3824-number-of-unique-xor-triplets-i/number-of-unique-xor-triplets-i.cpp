class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        int n=nums.size();
        if(n<=2){
            return n;
        }
        int count=bits(n);
        return 1<<count;
    }
    int bits(int n){
        int c=0;
        while(n){
            c++;
            n>>=1;
        }
        return c;
    }
};