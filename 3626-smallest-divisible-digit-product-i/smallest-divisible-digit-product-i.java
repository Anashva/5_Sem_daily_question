class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int k=product(n);
            if(k%t==0){
                return n;
            }
            n=n+1;
        }
    }
    public int product(int n){
        int p=1;
        while(n>0){
            p*=n%10;
            n/=10;
        }
        return p;
    }
}