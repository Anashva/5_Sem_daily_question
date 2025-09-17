class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;//base case when string is empty
        for(int i=1;i<=s.length();i++){
            for(String t:wordDict){
                int len=t.length();
                if(i>=len && dp[i-len]){
                    if(s.substring(i-len,i).equals(t)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
}