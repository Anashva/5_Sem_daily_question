class Solution {
public:
    vector<vector<string>> ans; 
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<char>> board(n,vector<char>(n,'.'));
        queen(board,n,0);
        return ans;
    }
    void queen(vector<vector<char>> &board,int n,int c){
        if(c==n){
            vector<string> ll;
            for(int i=0;i<n;i++){
                string t="";
                for(int j=0;j<n;j++){
                    t+=board[i][j];
                }
                ll.push_back(t);
            }
            ans.push_back(ll);
            return;
        }
        for(int r=0;r<n;r++){
            if(safe(board,r,c,n)){
                board[r][c]='Q';
                queen(board,n,c+1);
                board[r][c]='.';
            }
        }
    }
    bool safe(vector<vector<char>> &board,int r,int c,int n){
        // column
        for(int i=0;i<c;i++){
            if(board[r][i]=='Q'){
                return false;
            }
        }

        // upper left diagonal
        for(int i=r,j=c;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // lower left diagonal
        for(int i=r,j=c;i<n && j>=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
};