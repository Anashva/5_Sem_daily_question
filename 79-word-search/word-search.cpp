class Solution {
public:
    int n;
    int m;
    bool exist(vector<vector<char>>& board, string word) {
        n=board.size();
        m=board[0].size();
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(word[0]==board[i][j]){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& board, string word,int i,int j,int idx){
        if(idx==word.size()){
            return true;
        }
        if(i>=n || i<0 || j<0 || j>=m || board[i][j]!=word[idx]){
            return false;
        }
        char ch=board[i][j];
        board[i][j]='#';
        bool f=dfs(board,word,i+1,j,idx+1) || dfs(board,word,i,j+1,idx+1) || dfs(board,word,i-1,j,idx+1) || dfs(board,word,i,j-1,idx+1);
        board[i][j]=ch;
        return f;
    }
};