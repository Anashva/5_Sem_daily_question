class Solution {
    public long kMirror(int k, int n) {
        int l=1;
        long sum=0L;
        while(n>0){
            int half=(l+1)/2;
            int min=(int)Math.pow(10,half-1);
            int max=(int)Math.pow(10,half)-1;
            for(int num=min;num<=max;num++){
                String s=Integer.toString(num);
                StringBuilder sb=new StringBuilder(s);
                String t=new StringBuilder(sb).reverse().toString();
                if(l%2==0){
                    sb.append(t);
                }
                else{
                    sb.append(t.substring(1));
                }
                long val=Long.parseLong(sb.toString());
                String basek=basek(val,k);
                if(pallindrome(basek)){
                    sum+=val;
                    n--;
                    if(n==0){
                        break;
                    }
                }
            }
            l++;
        }
        return sum;
    }
    public String basek(long n,int k){
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        return sb.toString();
    }
    public boolean pallindrome(String s){
        StringBuilder sb=new StringBuilder(s);
        String t=sb.reverse().toString();
        return s.equals(t);
    }
}