class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        vector<int> visit(arr.size(),0);
        return reach(arr,start,visit);
    }
    bool reach(vector<int> &arr,int idx,vector<int> &visit){
        if(arr[idx]==0){
            return true;
        }
        if(idx>=arr.size() || idx<0 || visit[idx]){
            return false;
        }
        visit[idx]=1;
        if(idx+arr[idx]<arr.size()){
            if(reach(arr,idx+arr[idx],visit)){
                return true;
            }
        }
        if(idx-arr[idx]>=0){
            if(reach(arr,idx-arr[idx],visit)){
                return true;
            }
        }
        return false;
    }
};