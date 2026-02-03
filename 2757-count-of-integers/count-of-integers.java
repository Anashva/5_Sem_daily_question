class Solution {
    int mod=1000000007;
    int[][][] dp;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp=new int[23][2][401];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        String n1=subtract(num1);
        int l=solve(n1,0,1,0,min_sum,max_sum)%mod;
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        int r=solve(num2,0,1,0,min_sum,max_sum)%mod;
        return (r-l+mod)%mod;
    }
    public int solve(String s,int idx,int tight,int sum,int min,int max){
        if(idx==s.length()){
            if(sum>=min && sum<=max){
                return 1;
            }
            return 0;
        }
        if(dp[idx][tight][sum]!=-1){
            return dp[idx][tight][sum];
        }
        int lb=0;
        int ans =0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            ans=(ans+solve(s,idx+1,newt,sum+digit,min,max))%mod;
        }
        return dp[idx][tight][sum]=ans;
    }
    public String subtract(String s){
        int i=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(i>=0 & sb.charAt(i)=='0'){
            sb.setCharAt(i,'9');
            i--;
        }
        if(i<0){
            return "";
        }
        sb.setCharAt(i, (char)(sb.charAt(i) - 1));
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}