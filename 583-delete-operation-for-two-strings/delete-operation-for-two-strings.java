class Solution {
    public int minDistance(String word1, String word2) {
        return Min_OpsBU(word1,word2);
        
    }
    public static int Min_Ops(String s,String t,int i,int j){
        if(i==s.length()){
            return t.length()-j;
        }
        if(j==t.length()){
            return s.length()-i;
        }

        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=Min_Ops(s,t,i+1,j+1);
        }
        else{
            int d1=Min_Ops(s,t,i+1,j);
            int d2=Min_Ops(s,t,i,j+1);
            ans=Math.min(d1,d2)+1;
        }
        return ans;
    }
    public int Min_OpsBU(String s,String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=1;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int d1=dp[i-1][j];
                    int d2=dp[i][j-1];
                    dp[i][j]=Math.min(d1,d2)+1;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}