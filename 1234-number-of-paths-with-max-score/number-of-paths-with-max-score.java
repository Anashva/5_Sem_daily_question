class Solution {
    int mod = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        char[][] grid=new char[board.size()][board.size()];
        for(int i=0;i<board.size();i++){
            String s=board.get(i);
            for(int j=0;j<s.length();j++){
                grid[i][j]=s.charAt(j);
            }
        }
        int[][] dp1=new int[board.size()][board.size()];
        for(int[] a:dp1){
            Arrays.fill(a,-1);
        }
        grid[board.size()-1][board.size()-1]='0';
        int sum=path(grid,grid.length-1,grid[0].length-1,dp1);
        if(sum<0){
            return new int[]{0,0};
        }
        int[][][] dp2=new int[grid.length][grid.length][sum+1];
        for(int[][] a:dp2){
           for(int[]b:a){
            Arrays.fill(b,-1);
           }
        }   
        int path=path2(grid,grid.length-1,grid.length-1,0,sum,dp2);
        return new int[]{sum,path};   
    }

    public int path(char[][] grid,int cr,int cc,int[][]dp1){
        if(cr<0 || cc<0 || grid[cr][cc]=='X'){
            return Integer.MIN_VALUE/4;
        }
        if(cr==0 && cc==0){
            return 0;
        }
        if(dp1[cr][cc]!=-1){
            return dp1[cr][cc];
        }
        int ans=grid[cr][cc]-'0';
        int up=path(grid,cr-1,cc,dp1);
        int left=path(grid,cr,cc-1,dp1);
        int upleft=path(grid,cr-1,cc-1,dp1);
        ans=ans+Math.max(up,Math.max(left,upleft));
        return dp1[cr][cc]=ans;
    }

    public int path2(char[][] grid,int cr,int cc,int sum,int max,int[][][]dp2){
        if(cr<0 || cc<0 || grid[cr][cc]=='X' || sum>max){
            return 0;
        }
        if(cr==0 && cc==0){
            if(max==sum){
                return 1;
            }
            return 0;
        }
        if(dp2[cr][cc][sum]!=-1){
            return dp2[cr][cc][sum];
        }
        int ans=grid[cr][cc]-'0';
        int up=path2(grid,cr-1,cc,sum+ans,max,dp2);
        int left=path2(grid,cr,cc-1,sum+ans,max,dp2);
        int upleft=path2(grid,cr-1,cc-1,sum+ans,max,dp2);
        return dp2[cr][cc][sum]=(up+left+upleft)%mod;
    }

}