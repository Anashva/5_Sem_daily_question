class Solution {
    int mod=1000000007;
    int[][][][] dp;
    public int countNumbers(String l, String r, int b) {
        String s=subtract(l);
        String nl=Tobase(s,b);
        String nr=Tobase(r,b);
        dp=new int[nl.length()+1][2][2][11];
        for(int[][][] a:dp){
            for(int[][] k:a){
                for(int[] c:k){
                    Arrays.fill(c,-1);
                }
            }
        }
        int left=count(nl,0,1,1,0,b);
        dp=new int[nr.length()+1][2][2][11];
        for(int[][][] a:dp){
            for(int[][] k:a){
                for(int[] c:k){
                    Arrays.fill(c,-1);
                }
            }
        }
        int right=count(nr,0,1,1,0,b);
        return (right-left+mod)%mod;
    }
    public int count(String s,int idx,int tight,int lz,int last,int b){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][lz][last]!=-1){
            return dp[idx][tight][lz][last];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' :b-1;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1 : 0;
            if(digit==0 && lz==1){
                ans=(ans+count(s,idx+1,newt,lz,last,b))%mod;
            }
            else{
                if(digit>=last){
                    ans=(ans+count(s,idx+1,newt,(lz==1 && digit==0) ? 1 :0,digit,b))%mod;
                }
                
            }
        }
        return dp[idx][tight][lz][last]=ans;
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
    public String Tobase(String s,int b){
        java.math.BigInteger num=new java.math.BigInteger(s);
        return num.toString(b);
    }
}