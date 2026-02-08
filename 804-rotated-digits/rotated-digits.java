class Solution {
    int[][][][] dp;
    public int rotatedDigits(int n) {
        String s=Integer.toString(n);
        dp=new int[s.length()][2][2][2];
        for(int[][][] a:dp){
            for(int[][] b:a){
                for(int[] c:b){
                    Arrays.fill(c,-1);
                }
            }
        }
        return count(s,0,1,1,0);
    }
    public int count(String s,int idx,int tight,int lz,int rotate){
        if(idx==s.length()){
            return (rotate==1 && lz==0) ? 1:0;
        }
        if(dp[idx][tight][lz][rotate]!=-1){
            return dp[idx][tight][lz][rotate];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub) ? 1 : 0;
            if(digit==3 || digit==4 || digit==7){
                continue;
            }
            else if(digit==0 && lz==1){
                ans+=count(s,idx+1,newtight,lz,rotate);
            }
            else{
                int newrotate=rotate;
                int newlz=(lz==1 && digit==0) ? 1 :0 ;
                if(digit==2 || digit==5 || digit==9 || digit==6){
                    newrotate=1;
                }
                ans+=count(s,idx+1,newtight,newlz,newrotate);
            }
        }
        return dp[idx][tight][lz][rotate]=ans;
    }
}