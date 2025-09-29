class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    boolean ans=search(board,word,i,j,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,String word,int cr,int cc, int idx){
        if(idx==word.length()){
            return true;
        }
        if(cr<0 || cr>=board.length || cc<0 || cc>=board[0].length || word.charAt(idx)!=board[cr][cc]){
            return false;
        }
        char ch=board[cr][cc];
        board[cr][cc]='*';
        boolean f= search(board,word,cr+1,cc,idx+1) ||
        search(board,word,cr,cc+1,idx+1) ||
        search(board,word,cr-1,cc,idx+1) ||
        search(board,word,cr,cc-1,idx+1);
        board[cr][cc]=ch;
        return f;
    }
}