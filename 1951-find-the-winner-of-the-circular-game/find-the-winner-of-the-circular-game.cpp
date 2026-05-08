class Solution {
public:
    int findTheWinner(int n, int k) {
        queue<int> q;
        int c=0;
        for(int i=1;i<=n;i++){
            q.push(i);
        }
        while(q.size()>1){
            int r=q.front();
            q.pop();
            c++;
            if(c==k){
                c=0;
            }
            else{
                q.push(r);
            }
        }
        return q.front();
    }
};