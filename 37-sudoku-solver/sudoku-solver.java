class Solution {
    public void solveSudoku(char[][] board) {
        Print(board,0,0);
    }
    public static boolean Print(char[][]grid,int row,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
        if(grid[row][col]!='.'){
            return Print(grid,row,col+1);
        }
        else{
            for(int val=1;val<=9;val++){
                if(istisafe(grid,row,col,val)){
                    char ch=String.valueOf(val).charAt(0);
                    grid[row][col]=ch;
                    boolean ans=Print(grid,row,col+1);
                    if(ans){
                        return true;
                    }
                    grid[row][col]='.';
                }
            }
        }
        return false;
    }
    public static boolean istisafe(char[][] grid,int row,int col,int val){
//        row

        for(int i=0;i<grid.length;i++){
            char ch=String.valueOf(val).charAt(0);
            if(grid[row][i]==ch){
                return false;
            }
        }
//        col
        for(int i=0;i<grid.length;i++){
            char ch=String.valueOf(val).charAt(0);
            if(grid[i][col]==ch){
                return false;
            }
        }
//        3*3 matrix
            int r=row-row%3;
            int c=col-col%3;
            for(int i=r;i<r+3;i++){
                for(int j=c;j<c+3;j++){
                    char ch=String.valueOf(val).charAt(0);
                    if(grid[i][j]==ch){
                        return false;
                    }
                }
            }
        return true;
    }
}