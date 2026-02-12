class Solution {
    public int countSpecialNumbers(int n) {
        String s=Integer.toString(n);
        return count(s,0,1,1,0);
    }
    public int count(String s,int idx,int tight,int lz,int mask){
        if(idx==s.length()){
            return lz==1 ? 0 :1;
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0': 9;
        int ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int newt=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0){
                ans+=count(s,idx+1,newt,lz,mask);
            }
            else{
                if((mask & (1 <<digit)) !=0){
                    continue;
                }
                int nlz=(lz==1 && digit==0) ? 1:0;
                int newmask=(mask | (1 <<digit));
                ans+=count(s,idx+1,newt,nlz,newmask);
            }
        }
        return ans;
    }
}
