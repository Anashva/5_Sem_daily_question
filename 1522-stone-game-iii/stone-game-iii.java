class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[][] dp=new int[stoneValue.length][2];
        for(int []a:dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        int ans=stone(stoneValue,0,1,dp);
        if(ans>0){
            return "Alice";
        }
        if(ans==0){
            return "Tie";
        }
        return "Bob";
    }
    public int stone(int[]arr,int idx,int turn,int[][]dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][turn]!=Integer.MIN_VALUE){
            return dp[idx][turn];
        }

        if(turn==1){
            int sum1=arr[idx]+stone(arr,idx+1,0,dp);
            int sum2=Integer.MIN_VALUE;
            int sum3=Integer.MIN_VALUE;
            if(idx+1<arr.length){
                sum2=arr[idx+1]+arr[idx]+stone(arr,idx+2,0,dp);
            }
            if(idx+2<arr.length){
                sum3=arr[idx+2]+arr[idx+1]+arr[idx]+stone(arr,idx+3,0,dp);
            }
            dp[idx][turn]=Math.max(sum1, Math.max(sum2, sum3));
            return Math.max(sum1, Math.max(sum2, sum3));
        }
        else{
            int sum1=-(arr[idx])+stone(arr,idx+1,1,dp);
            int sum2=Integer.MAX_VALUE;
            int sum3=Integer.MAX_VALUE;
            if(idx+1<arr.length){
                sum2=-(arr[idx+1]+arr[idx])+stone(arr,idx+2,1,dp);
            }
            if(idx+2<arr.length){
                sum3=-(arr[idx+2]+arr[idx+1]+arr[idx])+stone(arr,idx+3,1,dp);
            }
            dp[idx][turn]=Math.min(sum1, Math.min(sum2, sum3));
            return Math.min(sum1, Math.min(sum2, sum3));
        }
    }
}