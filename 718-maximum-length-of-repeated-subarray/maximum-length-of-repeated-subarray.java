class Solution {
    int res=0;
    public int findLength(int[] num1, int[] num2) {
        res=0;
        int[][] dp=new int[num1.length][num2.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        TD(num1,num2,0,0,dp);
        return res;
    }

    public int TD(int[] num1,int []num2,int i,int j,int[][] dp){
        if(i>=num1.length || j>=num2.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(num1[i]==num2[j]){
            ans=1+TD(num1,num2,i+1,j+1,dp);
            res=Math.max(ans,res);
        }
        TD(num1,num2,i,j+1,dp);
        TD(num1,num2,i+1,j,dp);

        return dp[i][j]=ans;
    }
    public int sub(int[] num1,int[] num2,int i,int j){
        if(i==num1.length || j==num2.length){
            return 0;
        }
        int ans=0;
        if(num1[i]==num2[j]){
            ans=1+sub(num1,num2,i+1,j+1);
            res=Math.max(ans,res);
        }
        sub(num1,num2,i,j+1);
        sub(num1,num2,i+1,j);
        return res;
    }
}