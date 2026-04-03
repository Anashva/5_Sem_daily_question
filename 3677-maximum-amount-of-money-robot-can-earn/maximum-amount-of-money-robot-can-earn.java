class Solution {
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        dp = new Integer[coins.length][coins[0].length][3];
        // max(coins,0,0,2,0);
        return count(coins,0,0,2);
    }
    public void max(int[][] grid,int i,int j,int k,int sum){
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]<0 && k>0){
                // ans=Math.max(ans,sum);
                return;
            }
            // ans=Math.max(ans,sum+grid[i][j]);
            return;
        }
        if(i>=grid.length || j>=grid[0].length || k<0){
            return;
        }

        if (dp[i][j][k] != null && dp[i][j][k] >= sum) {
            return;
        }
        dp[i][j][k] = sum;

        if(grid[i][j]<0 && k>0){
            max(grid,i+1,j,k-1,sum);
            max(grid,i,j+1,k-1,sum);
        }
        max(grid,i+1,j,k,sum+grid[i][j]);
        max(grid,i,j+1,k,sum+grid[i][j]);
    }

    public int count(int[][] grid,int i,int j,int k){
        if(i==grid.length-1 && j==grid[0].length-1){
            if(grid[i][j]<0 && k>0){
                return 0;
            }
            return grid[i][j];
        }
        if(i>=grid.length || j>=grid[0].length || k<0){
            return Integer.MIN_VALUE;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        int ans=Integer.MIN_VALUE;
        if(grid[i][j]<0 && k>0){
            int down=count(grid,i+1,j,k-1);
            int right=count(grid,i,j+1,k-1);
            ans=Math.max(ans,down);
            ans=Math.max(ans,right);
        } 
        int down=count(grid,i+1,j,k);
        int right=count(grid,i,j+1,k);
        if(down!=Integer.MIN_VALUE){
            ans=Math.max(ans,down+grid[i][j]);
        }
        if(right!=Integer.MIN_VALUE){
            ans=Math.max(ans,right+grid[i][j]);
        }
        return dp[i][j][k]=ans;

    }
}