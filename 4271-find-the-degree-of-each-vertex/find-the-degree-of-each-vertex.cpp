class Solution {
public:
    vector<int> findDegrees(vector<vector<int>>& matrix) {
        int n=matrix.size();
        vector<int> ans(n,0);
        vector<int> in(n,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    in[i]++;
                    in[j]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=in[i]/2;
        }
        return ans;
    }
};