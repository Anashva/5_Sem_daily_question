class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        int n=mat.size();
        int m=mat[0].size();
        int l=0;
        int h=m-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int r=solve(mat,mid);
            int left=mid-1>=0 ? mat[r][mid-1] : INT_MIN;
            int right=mid+1<m ? mat[r][mid+1] : INT_MIN;
            if(mat[r][mid]>left && mat[r][mid]>right){
                return {r,mid};
            }
            else if(left>mat[r][mid]){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return {-1,-1};
    }
    int solve(vector<vector<int>>& mat, int c){
        int n=mat.size();
        int m=mat[0].size();
        int mx=INT_MIN;
        int idx=0;
        for(int i=0;i<n;i++){
            if(mx<mat[i][c]){
                mx=mat[i][c];
                idx=i;
            }
        }
        return idx;
    }

};