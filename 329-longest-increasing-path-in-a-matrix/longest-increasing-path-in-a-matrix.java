class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int ans=0;
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans=Math.max(ans,lip(matrix,i,j,dp,Integer.MIN_VALUE));
            }
        }
        return ans;
    }
    public static int lip(int[][] matrix,int i,int j,int[][]dp,int val){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return 0;
        }
        if(matrix[i][j]<=val){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        val=matrix[i][j];
        int ans=0;
        int l=lip(matrix,i-1,j,dp,val)+1;
        int r=lip(matrix,i+1,j,dp,val)+1;
        int t=lip(matrix,i,j-1,dp,val)+1;
        int b=lip(matrix,i,j+1,dp,val)+1;
        ans=Math.max(ans,Math.max(r,Math.max(l,Math.max(t,b))));
        return dp[i][j]=ans;
    }
}