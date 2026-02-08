class Solution {
    int[][][][] dp;
    int mod=1000000007;
    public int countSteppingNumbers(String low, String high) {
        String l=subtract(low);
        dp=new int[l.length()][2][2][10];
        for(int[][][] a:dp){
            for(int[][] b:a){
                for(int[] c:b){
                    Arrays.fill(c,-1);
                }
            }
        }
        int left=count(l,0,1,1,0);
        dp=new int[high.length()][2][2][10];
        for(int[][][] a:dp){
            for(int[][] b:a){
                for(int[] c:b){
                    Arrays.fill(c,-1);
                }
            }
        }
        int right=count(high,0,1,1,0);
        return (right-left+mod)%mod;
    }
    public int count(String s,int idx,int tight,int lz,int prev){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][lz][prev]!=-1){
            return dp[idx][tight][lz][prev];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub) ? 1 : 0;
            if(lz==1 && digit==0){
                ans=(ans+count(s,idx+1,newtight,lz,prev))%mod;;
            }
            else if(Math.abs(prev-digit)==1 || lz==1){
                int newlz=(lz==1 && digit==0) ? 1 :0;
                ans=(ans+count(s,idx+1,newtight,newlz,digit))%mod;
            }
        }
        return dp[idx][tight][lz][prev]=ans;
    }
    public String subtract(String s){
        StringBuilder sb=new StringBuilder(s);
        int i=s.length()-1;
        while(i>=0 && sb.charAt(i)=='0'){
            sb.setCharAt(i,'9');
            i--;
        }
        if(i<0){
            return "";
        }
        sb.setCharAt(i,(char)(sb.charAt(i)-1));
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}