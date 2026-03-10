class Solution {
public:
    int minCost(int n) {
        return count(n);
    }
    int count(int n){
        if(n<1){
            return 0;
        }
        return (n-1)+count(n-1);
    }
};