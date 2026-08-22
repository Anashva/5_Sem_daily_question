class Solution {
    public boolean checkDivisibility(int n) {
        int total=sum(n)+pro(n);
        if(n%total==0){
            return true;
        }
        return false;
    }
    public int pro(int n){
        long p=1;
        while(n>0){
            int r=n%10;
            p*=r;
            n/=10;
        }
        return (int)p;
    }
    public int sum(int n){
        int s=0;
        while(n>0){
            s=s+n%10;
            n/=10;
        }
        return s;
    }
}