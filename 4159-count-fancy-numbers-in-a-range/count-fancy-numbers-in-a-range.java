class Solution {
    long[][][][][][] dp;
    public long countFancy(long l, long r) {
        l=l-1;
        String si=Long.toString(l);
        dp=new long[si.length()][2][2][11][4][200];
        for(long[][][][][] a:dp){
            for(long[][][][] b:a){
                for(long[][][] c:b){
                    for(long[][] d:c){
                        for(long[] e:d){
                            Arrays.fill(e,-1);
                        }
                    }
                }
            }
        }
        long l1=count(si,0,1,1,10,0,0);
        String ei=Long.toString(r);
        dp=new long[ei.length()][2][2][11][4][200];
        for(long[][][][][] a:dp){
            for(long[][][][] b:a){
                for(long[][][] c:b){
                    for(long[][] d:c){
                        for(long[] e:d){
                            Arrays.fill(e,-1);
                        }
                    }
                }
            }
        }
        long r1=count(ei,0,1,1,10,0,0);
        return r1-l1;
    }
    public long count(String s,int idx,int tight,int lz,int last,int turn,int sum){
        if(idx==s.length()){
            if(lz==1){
                return 0;
            }
            if(turn==1 || turn==2){
                return 1;
            }
            return good(sum ) ? 1:0;
        }
        if(turn==-1){
            turn =3;
        }
        if(tight==0 && dp[idx][tight][lz][last][turn][sum]!=-1){
            return dp[idx][tight][lz][last][turn][sum];
        }

        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' :9;
        long ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int ntight=(tight==1 && digit==ub) ? 1:0;
            int nlz=(lz==1 && digit==0) ? 1:0;
            int nturn=turn;
            if(lz==1 && digit==0){
                ans+=count(s,idx+1,ntight,nlz,last,turn,sum);
            }
            else{
                if(nlz==0 && last!=10){
                    if(digit>last){
                        nturn=(turn==0 ? 1 : (turn==1? 1:-1));
                    }
                    else if(digit<last){
                        nturn=(turn==0 ? 2:(turn==2 ? 2 : -1));
                    }
                    else{
                        nturn =-1;
                    }
                }
                // if(nturn==-1){
                //     continue;
                // }
                ans+=count(s,idx+1,ntight,nlz,digit,nturn,sum+digit);
                
            }
            
        }
        if(turn==3){
            turn= -1;
        }
        return dp[idx][tight][lz][last][turn==-1 ? 3:turn][sum]=ans;
    }
    public boolean good(int sum){
        String s=Integer.toString(sum);
        return monotone(s);
    }
    public boolean monotone(String s){
        boolean inc=true;
        boolean dec=true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<=s.charAt(i-1)){
                inc=false;
            }
            if(s.charAt(i)>=s.charAt(i-1)){
                dec=false;
            }
        }
        return inc || dec;
    }
}