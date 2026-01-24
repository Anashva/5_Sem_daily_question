class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        int digit=9;
        int curr=9;
        for(int i=2;i<=n;i++){
            curr=curr*digit;
            dp[i]=dp[i-1]+curr;
            digit--;
        }
        return dp[n];
    }
    
}