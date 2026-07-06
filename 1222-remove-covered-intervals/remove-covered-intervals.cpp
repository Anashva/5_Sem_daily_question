class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& arr) {
        sort(arr.begin(),arr.end(),[](const vector<int>& a,const vector<int> &b){
            if(a[0]!=b[0]){
                return a[0]<b[0];
            }
            return a[1]>b[1];
        });
        int ans=0;
        int a=arr[0][1];
        for(int i=1;i<arr.size();i++){
            if(arr[i][1]<=a){
                ans++;
            }
            else{
                a=arr[i][1];
            }
        }
        return arr.size()-ans;
    }
};