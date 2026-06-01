class Solution {
    public void solve(char[][] board) {
        if(board.length<2 || board[0].length<2){
            return;
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                surround(board,i,0);
            }
            if(board[i][board[0].length-1]=='O'){
                surround(board,i,board[0].length-1);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                surround(board,0,i);
            }
            if(board[board.length-1][i]=='O'){
                surround(board,board.length-1,i);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='x'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void surround(char[][] board,int cr,int cc){
        if(cr<0 || cc<0 || cr>=board.length || cc>=board[0].length || board[cr][cc]!='O'){
            return;
        }
        board[cr][cc]='x';
        surround(board,cr+1,cc);
        surround(board,cr-1,cc);
        surround(board,cr,cc+1);
        surround(board,cr,cc-1); 
    }
}