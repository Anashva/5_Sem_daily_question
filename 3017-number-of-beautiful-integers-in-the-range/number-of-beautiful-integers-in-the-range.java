class Solution {
    int[][][][][][] dp;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        low=low-1;
        dp=new int[11][2][2][21][11][11];
        for(int[][][][][] a:dp){
            for(int[][][][] b:a){
                for(int[][][] c:b){
                    for(int[][] d:c){
                        for(int[] e:d){
                            Arrays.fill(e,-1);
                        }
                    }
                }
            }
        }
        String l=Integer.toString(low);
        String r=Integer.toString(high);
        int left=solve(l,0,1,k,0,0,0,true);
        for(int[][][][][] a:dp){
            for(int[][][][] b:a){
                for(int[][][] c:b){
                    for(int[][] d:c){
                        for(int[] e:d){
                            Arrays.fill(e,-1);
                        }
                    }
                }
            }
        }
        int right=solve(r,0,1,k,0,0,0,true);
        return right-left;
    }
    public int solve(String s,int idx,int tight,int k,int even,int odd,int last,boolean lz){
        if(idx==s.length()){
            if(!lz && even==odd && last==0){
                return 1;
            }
            return 0;
        }
        int lzstate=lz ? 1:0;
        if(dp[idx][tight][lzstate][last][even][odd]!=-1){
            return dp[idx][tight][lzstate][last][even][odd];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            if(lz && digit==0){
                ans+=solve(s,idx+1,newt,k,even,odd,last,true);
            }
            else{
                int newodd=odd+((digit & 1)==1 ? 1 :0);
                int neweven=even+((digit & 1)==0 ? 1:0);
                int newlast=(last*10+digit)%k;
                ans+=solve(s,idx+1,newt,k,neweven,newodd,newlast,false);
            }
        }
        return dp[idx][tight][lzstate][last][even][odd]=ans;
    }
}