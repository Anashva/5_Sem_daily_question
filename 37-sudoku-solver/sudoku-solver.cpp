class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
    bool solve(vector<vector<char>>& board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(safe(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
    bool safe(vector<vector<char>>& board,int r,int c,char ch){
        // row
        for(int i=0;i<9;i++){
            if(board[i][c]==ch){
                return false;
            }
        }
        // col
        for(int i=0;i<9;i++){
            if(board[r][i]==ch){
                return false;
            }
        }

        int row=r-r%3;
        int col=c-c%3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
};