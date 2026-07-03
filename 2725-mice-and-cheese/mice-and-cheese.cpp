class Solution {
public:
    int miceAndCheese(vector<int>& reward1, vector<int>& reward2, int k) {
        // priority_queue<int,vector<int>, greater<int>> pq;
        // int total=0;
        // for(int i=0;i<reward1.size();i++){
        //     total+=reward2[i];
        //     int diff=reward1[i]-reward2[i];
        //     pq.push(diff);
        //     if(pq.size()>k){
        //         pq.pop();
        //     }
        // }
        // while(!pq.empty()){
        //     total+=pq.top();
        //     pq.pop();
        // }

        int n=reward1.size();
        vector<int> diff;
        int total=0;
        for(int i=0;i<n;i++){
            total+=reward2[i];
            diff.push_back(reward1[i]-reward2[i]);
        }
        sort(diff.begin(),diff.end(),greater<int>());
        for(int i=0;i<k;i++){
            total+=diff[i];
        }
        return total;
    }
};