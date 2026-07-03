class Solution {
public:
    int miceAndCheese(vector<int>& reward1, vector<int>& reward2, int k) {
        priority_queue<int,vector<int>, greater<int>> pq;
        int total=0;
        for(int i=0;i<reward1.size();i++){
            total+=reward2[i];
            int diff=reward1[i]-reward2[i];
            pq.push(diff);
            if(pq.size()>k){
                pq.pop();
            }
        }
        while(!pq.empty()){
            total+=pq.top();
            pq.pop();
        }
        return total;
    }
};