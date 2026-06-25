class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int n=board.size();
        int m=board[0].size();
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                region(board,i,0);
            }
            if(board[i][m-1]=='O'){
                region(board,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                region(board,0,i);
            }
            if(board[n-1][i]=='O'){
                region(board,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='x'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    void region(vector<vector<char>> &grid,int i,int j){
        if(i<0 || j<0 || i>=grid.size() || j>=grid[0].size() || grid[i][j]!='O'){
            return;
        }
        grid[i][j]='x';
        region(grid,i+1,j);
        region(grid,i-1,j);
        region(grid,i,j+1);
        region(grid,i,j-1);
    }
};