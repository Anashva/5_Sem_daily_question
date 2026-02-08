class Solution {
    HashSet<Integer> st;
    int[][][] dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        st=new HashSet<>();
        for(String s:digits){
            st.add(Integer.parseInt(s));
        }
        String s=Integer.toString(n);
        dp=new int[s.length()][2][2];
        for(int[][] a:dp){
            for(int[] b:a){
                Arrays.fill(b,-1);
            }
        }
        return count(s,0,1,1)-1;

    }
    public int count(String s,int idx,int tight,int lz){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][tight][lz]!=-1){
            return dp[idx][tight][lz];
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0' : 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newtight=(tight==1 && digit==ub) ? 1:0;
            if(digit==0 && lz==1){
                ans+=count(s,idx+1,newtight,lz);
            }
            else{
                if(st.contains(digit)){
                    int newlz=(lz==1 && digit==0) ? 1 :0;
                    ans+=count(s,idx+1,newtight,newlz);
                }
            }
        }
        return dp[idx][tight][lz]=ans;
    }
}