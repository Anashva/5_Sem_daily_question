class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean [] dp=new boolean[n];
        dp[0]=true;
        for(int i=0,j=0;i<n;i++){
            if(dp[i]){
                for(j=Math.max(i+minJump,j);j<=Math.min(n-1,i+maxJump);j++){
                    if(s.charAt(j)=='0'){
                        if(j==n-1){
                            return true;
                        }
                        dp[j]=true;
                    }
                }
            }
        }
        return false;
    }
}