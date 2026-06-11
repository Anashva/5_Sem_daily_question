class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int ans=1;
        sort(intervals.begin(),intervals.end(),[](const vector<int> &a,const vector<int> &b){
            return a[1]<b[1];
        });
        int n=intervals.size();
        int end=intervals[0][1];
        for(int i=1;i<intervals.size();i++){
            if(end<=intervals[i][0]){
                end=intervals[i][1];
                ans++;
            }
        }
        return n-ans;
    }
};