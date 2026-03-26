class Solution {
    HashMap<String,Long> mp;
    public int beautifulNumbers(int l, int r) {
        l--;
        String si=Integer.toString(l);
        mp=new HashMap<>();
        long l1=beautiful(si,0,1,1,1,0);
        String ei=Integer.toString(r);
        mp=new HashMap<>();
        long r1=beautiful(ei,0,1,1,1,0);
        return (int)(r1-l1);
    }
    public long beautiful(String s,int idx,int tight,int lz,int prod,int sum){
        if(idx==s.length()){
            if(lz==1){
                return 0;
            }
            return sum!=0 && prod%sum==0 ? 1:0;
        }
        String key=idx+"|"+tight+"|"+lz+"|"+prod+"|"+sum;
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0': 9;
        long ans=0;
        for(int digit=lb;digit<=ub;digit++){
            int ntight=(tight==1 && digit==ub) ? 1:0;
            int nlz=(lz==1 && digit==0) ? 1:0;
            if(lz==1 && digit==0){
                ans+=beautiful(s,idx+1,ntight,lz,prod,sum);
            }
            else{
                ans+=beautiful(s,idx+1,ntight,nlz,prod*digit,sum+digit);
            }
        }
        mp.put(key,ans);
        return ans;
    }
}