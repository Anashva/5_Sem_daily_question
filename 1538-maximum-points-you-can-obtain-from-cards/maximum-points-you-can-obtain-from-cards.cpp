class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int sum=0;
        int ans=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        ans=sum;
        // moving the window fom front to back for k times
        //  as take one from right and remove one from left
        int n=cardPoints.size();
        for(int i=0;i<k;i++){
            sum-=cardPoints[k-i-1];
            sum+=cardPoints[n-i-1];
            ans=max(ans,sum);
        }
        return ans;
    }
};