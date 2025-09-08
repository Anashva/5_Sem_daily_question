class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return (int)subs(s,dp,0)%MOD;
    }
    public int subs(String s,int [] dp,int i){
        if(i>=s.length()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=0;
        HashSet<Character> st=new HashSet<>();
        for(int idx=i;idx<s.length();idx++){
            if(!st.contains(s.charAt(idx))){
                st.add(s.charAt(idx));
                ans=(ans%MOD+1+subs(s,dp,idx+1))%MOD;
            }
        }
        return dp[i]=ans;
    }
}