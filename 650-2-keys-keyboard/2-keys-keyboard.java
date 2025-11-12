class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        // 1 added here because 1step is always to copy all
        return  1+step(1,1,n);
    }
    public int step(int paste,int len,int n){
        if(len==n){
            return 0;
        }
        if(len>n){
            return 1000;
        }
        int c=2+step(len,len*2,n);
        int p=1+step(paste,len+paste,n);
        return Math.min(c,p);
    }
}