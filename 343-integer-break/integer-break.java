class Solution {
    public int integerBreak(int n) {
        if(n==2 || n==3){
            return n-1;
        }
        int k=1;
        int ans=0;
        if(n%3==0){
            ans=n/3;
        }
        else if((n-4)%3==0){
            ans=(n-4)/3;
            k=4;
        }
        else{
            ans=(n-2)/3;
            k=2;
        }
        return k*(int)Math.pow(3,ans);
    }
}