class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean c=validsudoku(board);
        return c;
    }
    public boolean validsudoku(char[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {

                if(board[row][col] != '.' && !istisafe(board, row, col, board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean istisafe(char[][] grid,int row,int col,char ch){
//        row

        for(int i=0;i<grid.length;i++){
            // char ch = String.valueOf(val).charAt(0);
            if(i!=col){
                if(grid[row][i]==ch){
                return false;
            }
            }
        }
//        col
        for(int i=0;i<grid.length;i++){
            // char ch = String.valueOf(val).charAt(0);
            if(i!=row){
                if(grid[i][col]==ch){
                return false;
                }
            }
        }
//        3*3 matrix
            int r=row-row%3;
            int c=col-col%3;
            for(int i=r;i<r+3;i++){
                for(int j=c;j<c+3;j++){
                    // char ch = String.valueOf(val).charAt(0);
                    if(i!=row && j!=col){
                        if(grid[i][j]==ch){
                        return false;
                    }
                    }
                }
            }
        return true;
    }
}