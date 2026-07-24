class Solution {
public:
    vector<int> ll;
    vector<vector<int>> ans;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        solve(candidates,target,0);
        return ans;
    }
    void solve(vector<int>& arr,int val,int idx){
        if(val==0){
            ans.push_back(ll);
            return;
        }
        for(int i=idx;i<arr.size();i++){
            if(val>=arr[i]){
                ll.push_back(arr[i]);
                solve(arr,val-arr[i],i);
                ll.pop_back();
            }
        }
    }
};