class Solution {
public:
    pair<int,int> get(int idx,int n){
        int r=(idx-1)/n;
        int c=(idx-1)%n;
        if(r%2==1){
            c=n-1-c;
        }
        r=n-1-r;
        return {r,c};
    }
    int snakesAndLadders(vector<vector<int>>& board) {
        int n=board.size();
        vector<vector<int>> dist(n,vector<int>(n,-1));
        queue<Pair> q;
        q.push(Pair(1,0));
        dist[n-1][0]=1;
        while(!q.empty()){
            Pair rp=q.front();
            q.pop();
            int x=rp.idx;
            int dis=rp.dis;
            if(x==n*n){
                return dis;
            }
            for(int idx=x+1;idx<=min(x+6,n*n);idx++){
                auto[r,c]=get(idx,n);
                if(dist[r][c]==-1){
                    dist[r][c]=1;
                    if(board[r][c]==-1){
                        q.push(Pair(idx,dis+1));
                    }
                    else{
                        q.push(Pair(board[r][c],dis+1));
                    }
                }
            }
        }
        return -1;
    }
    class Pair{
    public:
        int dis;
        int idx;
        Pair(int idx,int dis){
            this->dis=dis;
            this->idx=idx;
        }
    };
};